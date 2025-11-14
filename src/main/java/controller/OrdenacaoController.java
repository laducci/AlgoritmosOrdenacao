package controller;

import model.AlgoritmoOrdenacao;
import model.BubbleSort;
import model.InsertionSort;
import model.QuickSort;

public class OrdenacaoController {
    
    public ResultadoOrdenacao[] executarTodosAlgoritmos(int[] dados) {
        ResultadoOrdenacao[] resultados = new ResultadoOrdenacao[3];
        
        // Bubble Sort
        resultados[0] = executarAlgoritmo(new BubbleSort(dados.length), dados);
        
        // Insertion Sort
        resultados[1] = executarAlgoritmo(new InsertionSort(dados.length), dados);
        
        // Quick Sort
        resultados[2] = executarAlgoritmo(new QuickSort(dados.length), dados);
        
        return resultados;
    }
    
    private ResultadoOrdenacao executarAlgoritmo(AlgoritmoOrdenacao algoritmo, int[] dados) {
        // Clona os dados para não afetar o array original
        algoritmo.inserir(dados.clone());
        
        // Mede o tempo de execução
        long inicio = System.nanoTime();
        algoritmo.ordenar();
        long fim = System.nanoTime();
        
        long tempoExecucao = fim - inicio;
        boolean ordenado = algoritmo.estaOrdenada();
        
        return new ResultadoOrdenacao(algoritmo.getNome(), tempoExecucao, ordenado);
    }
}
