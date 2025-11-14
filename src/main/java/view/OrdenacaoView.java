package view;

import controller.ResultadoOrdenacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrdenacaoView {
    
    // metodo pra ler o arquivo e retornar um array de inteiros
    public int[] lerArquivo(String caminhoArquivo) throws FileNotFoundException {
        File arquivo = new File(caminhoArquivo);
        
        // primeiro conta quantos números existem no arquivo
        Scanner contador = new Scanner(arquivo);
        int tamanho = 0;
        while (contador.hasNextInt()) {
            contador.nextInt();
            tamanho++;
        }
        contador.close();
        
        // agora que contou, sabe o tamanho q o arr deve ter, e le os numeros pro array
        int[] listaNumeros = new int[tamanho];
        Scanner leitor = new Scanner(arquivo);
        int i = 0;
        while (leitor.hasNextInt() && i < tamanho) { // enquanto tiver numero e o array n tiver cheio, ele vai lendo e colocando no array
            listaNumeros[i] = leitor.nextInt(); 
            i++;
        }
        leitor.close();
        
        return listaNumeros;
    }
    
    public void exibirInicio(String nomeArquivo) { 
        System.out.println("Abrindo o arquivo: " + nomeArquivo);
    }
    
    // estrutura os resultados q qremos exibir
    public void exibirResultados(ResultadoOrdenacao[] resultados) { 
        for (int i = 0; i < resultados.length; i++) {
            System.out.println(resultados[i].getNomeAlgoritmo() + ":");
            System.out.println("Tempo: " + resultados[i].getTempoExecucao() + " ns");
            System.out.println("Ordenado? " + resultados[i].isOrdenadoCorretamente() + "\n");
        }
    }
    
    public void exibirErro(String mensagem) {
        System.out.println("Erro: " + mensagem);
    }
}
