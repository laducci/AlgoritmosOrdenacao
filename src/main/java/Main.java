import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] arquivos = {
                "aleatorio_100.csv",
                "aleatorio_1000.csv",
                "aleatorio_10000.csv",
                "crescente_100.csv",
                "crescente_1000.csv",
                "crescente_10000.csv",
                "decrescente_100.csv",
                "decrescente_1000.csv",
                "decrescente_10000.csv"
        };

        for (String nomeArquivo : arquivos) {
            System.out.println("Abrindo o arquivo: " + nomeArquivo);

            int[] listaNumeros = null; // aqui ele vai ser criado dps de contar os nums no arq

            try {
                File arquivo = new File("src/main/resources/" + nomeArquivo);
                Scanner contador = new Scanner(arquivo); // pra contar quantos nums tem no arq q estamos lendo
                int tamanho = 0;
                while (contador.hasNextInt()) {
                    contador.nextInt();
                    tamanho++;
                }
                contador.close(); // termina de contar e agr sabe o tamanho

                // agr q sabe o tamnh, cria o arr e le os nums
                listaNumeros = new int[tamanho];
                Scanner leitor = new Scanner(arquivo);
                int i = 0;
                while (leitor.hasNextInt() && i < tamanho) {
                    listaNumeros[i] = leitor.nextInt();
                    i++;
                }
                leitor.close();

            } catch (FileNotFoundException e) {
                System.out.println("arq não encontrado: " + nomeArquivo);
                continue;
            } // prox arq

// ALGORITMOS DE ORDENAÇÃO

            //  BUBBLE SORT 
            AlgoritmosOrdenacao bubble = new AlgoritmosOrdenacao(listaNumeros.length);
            bubble.inserir(listaNumeros.clone());  // clona para não afetar os outros testes

            System.out.println("Bubble Sort:");
            long inicioBubble = System.nanoTime();  // marca o tempo inicial em nanosegundos
            bubble.bubbleSort();
            long fimBubble = System.nanoTime();     // marca o tempo final

            // bubble.printLista();  //  para ver a lista ordenada
            System.out.println("Tempo Bubble Sort: " + (fimBubble - inicioBubble) + " ns");
            System.out.println("Ordenado? " + bubble.estaOrdenada() + "\n");


            //  INSERTION SORT 
            AlgoritmosOrdenacao insertion = new AlgoritmosOrdenacao(listaNumeros.length);
            insertion.inserir(listaNumeros.clone());

            System.out.println("Insertion Sort:");
            long inicioInsertion = System.nanoTime();
            insertion.insertionSort();
            long fimInsertion = System.nanoTime();

            // insertion.printLista();  //  para ver a lista ordenada
            System.out.println("Tempo Insertion Sort: " + (fimInsertion - inicioInsertion) + " ns");
            System.out.println("ordenado? " + insertion.estaOrdenada() + "\n");


            //  QUICK SORT 
            AlgoritmosOrdenacao quick = new AlgoritmosOrdenacao(listaNumeros.length);
            quick.inserir(listaNumeros.clone());

            System.out.println("Quick Sort:");
            long inicioQuick = System.nanoTime();
            quick.quickSort();
            long fimQuick = System.nanoTime();
            
            //quick.printLista();  //  para ver a lista ordenada
            System.out.println("Tempo Quick Sort: " + (fimQuick - inicioQuick) + " ns");
            System.out.println("ordenado? " + quick.estaOrdenada() + "\n");
        }
    }
}
