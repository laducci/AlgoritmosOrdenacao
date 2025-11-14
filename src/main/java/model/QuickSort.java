package model;

public class QuickSort extends AlgoritmoOrdenacao {
    
    public QuickSort(int tamanho) {
        super(tamanho);
    }
    
    @Override
    public String getNome() {
        return "Quick Sort";
    }
    
    @Override
    public int[] ordenar() {
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
}
