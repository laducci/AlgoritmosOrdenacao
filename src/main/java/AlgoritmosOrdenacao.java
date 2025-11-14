public class AlgoritmosOrdenacao {

    // array que vai armazenar os elementos a serem ordenados
    private int[] lista;

    private int tamanho; // tamanho que vamos usar pra lista

    public AlgoritmosOrdenacao(int tamanho) {
        this.lista = new int[tamanho]; // aq onde falamos q a lista vai ter tal tamanho
        this.tamanho = tamanho;
    }

    // aqui fazemos uma cópia simples dos valores dos arqs pra dentro do arr
    public void inserir(int[] valores) {
        // garante que não vamos estourar o array se o input for maior que o tamanho, ent se o array for de 1000 e o input tiver 1500 nums, só copia os 1000 primeiros
        this.tamanho = Math.min(valores.length, lista.length);

        for (int i = 0; i < tamanho; i++) { // basicamente pega item por item do arq e joga no nosso arr
            lista[i] = valores[i];
        }
    }

    //BUBBLE
    public int[] bubbleSort() {
        // o loop externo controla o número de passadas necessárias
        for (int i = 0; i < tamanho - 1; i++) {

            // para saber se houve alguma troca nessa passada
            // se não houve trocas, a lista já está ordenada e podemos parar 
            boolean trocou = false;

            // o loop interno percorre o array até o penúltimo elemento (pq o ultimo é com qm sera comparado)
            // o limite é diminuído a cada passada, pq os maiores elementos sao jogados pro final
            for (int j = 0; j < tamanho - i - 1; j++) {
                // se o elemento atual é maior que o próximo, troca os dois.
                if (lista[j] > lista[j + 1]) {
                    swap(j, j + 1);
                    trocou = true;
                }
            }

            // resulkt do nosso bool, se nd trocou, ja ordenado
            if (!trocou) {
                break;
            }
        }
        return lista;
    }

    //INSERTION
    public int[] insertionSort() {
        // começa do segundo elemento, ja q o primeiro é considerado ordenado
        for (int i = 1; i < tamanho; i++) {
            // guarda o valor do elemento atual que será inserido na parte ordenada
            int atual = lista[i];
            int j = i - 1;

            // enquanto houver elementos maiores que o atual na parte ordenada,
            // vamos empurrando esses elementos uma posição para a direita
            while (j >= 0 && lista[j] > atual) {
                lista[j + 1] = lista[j];
                j--;
            }

            // quando saímos do while, achamos o lugar certo do "atual"
            lista[j + 1] = atual;
        }

        return lista;
    }

    //QUICK
    public int[] quickSort() {
        quickSortRecursivo(0, tamanho - 1);
        return lista;
    }

    private void quickSortRecursivo(int inicio, int fim) {
        // condição de parada da recursão: quando o trecho tem 0 ou 1 elemento, já está ordenado
        if (inicio < fim) {
            // pivo = último elemento do trecho atual
            int pivo = lista[fim];

            // i vai marcar a posição do último elemento menor que o pivô
            int i = inicio - 1;

            // percorre o trecho separando os elementos menores e maiores que o pivô
            for (int j = inicio; j < fim; j++) {
                if (lista[j] < pivo) {
                    i++;
                    swap(i, j);
                }
            }

            // agora colocamos o pivô na posição correta:
            // tudo à esquerda dele é menor, tudo à direita é maior (ou igual)
            swap(i + 1, fim);
            int indicePivo = i + 1;

            // chamadas recursivas para ordenar as duas "metades" ao redor do pivô
            quickSortRecursivo(inicio, indicePivo - 1);  // lado esquerdo (menores)
            quickSortRecursivo(indicePivo + 1, fim);     // lado direito (maiores)
        }
    }

    // método auxiliar pra trocar dois elementos de lugar no array
    // swap: guarda um temporário para não perder o valor
    private void swap(int i, int j) {
        int guardar = lista[i];
        lista[i] = lista[j];
        lista[j] = guardar;
    }
    public boolean estaOrdenada() {
        for (int i = 0; i < tamanho - 1; i++) {
            if (lista[i] > lista[i + 1]) {
                return false;
            }
        }
        return true;
    } 
    public void printLista() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }
}
