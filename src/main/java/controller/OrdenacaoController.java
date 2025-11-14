package controller;

import model.AlgoritmoOrdenacao;
import model.BubbleSort;
import model.InsertionSort;
import model.QuickSort;

public class OrdenacaoController { // classe controller que vai gerenciar a execucao dos algoritmos
    
    public ResultadoOrdenacao[] executarTodosAlgoritmos(int[] dados) { // cria um array de resultados
        ResultadoOrdenacao[] resultados = new ResultadoOrdenacao[3]; // 3 pq temos 3 algoritmos
        
        // Bubble Sort
        resultados[0] = executarAlgoritmo(new BubbleSort(dados.length), dados); // cria o bubble sort com o tamanho dos dados
        
        // Insertion Sort
        resultados[1] = executarAlgoritmo(new InsertionSort(dados.length), dados); // cria o insertion sort com o tamanho dos dados
        
        // Quick Sort
        resultados[2] = executarAlgoritmo(new QuickSort(dados.length), dados); // cria o quick sort com o tamanho dos dados
        
        return resultados; // retorna o array com os resultados de todos os algoritmos
    }
    
    private ResultadoOrdenacao executarAlgoritmo(AlgoritmoOrdenacao algoritmo, int[] dados) { // coracao, executa cada algoritmo, com o tempo de execucao, e se ta ordenado

        algoritmo.inserir(dados.clone()); // é necessario clonar pq os algoritmos alteram o array
        
        // Mede o tempo de execução
        long inicio = System.nanoTime();
        algoritmo.ordenar();
        long fim = System.nanoTime();
        
        long tempoExecucao = fim - inicio;
        boolean ordenado = algoritmo.estaOrdenada(); // puxa o metodo la do algoritmoordenacao 
        
        return new ResultadoOrdenacao(algoritmo.getNome(), tempoExecucao, ordenado);
    }
}
