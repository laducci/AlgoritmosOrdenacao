package view;

import controller.ResultadoOrdenacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrdenacaoView {
    
    public int[] lerArquivo(String caminhoArquivo) throws FileNotFoundException {
        File arquivo = new File(caminhoArquivo);
        
        // Primeiro, conta quantos números existem no arquivo
        Scanner contador = new Scanner(arquivo);
        int tamanho = 0;
        while (contador.hasNextInt()) {
            contador.nextInt();
            tamanho++;
        }
        contador.close();
        
        // Agora que sabe o tamanho, cria o array e lê os números
        int[] listaNumeros = new int[tamanho];
        Scanner leitor = new Scanner(arquivo);
        int i = 0;
        while (leitor.hasNextInt() && i < tamanho) {
            listaNumeros[i] = leitor.nextInt();
            i++;
        }
        leitor.close();
        
        return listaNumeros;
    }
    
    public void exibirInicio(String nomeArquivo) {
        System.out.println("Abrindo o arquivo: " + nomeArquivo);
    }
    
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
