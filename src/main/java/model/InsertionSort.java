package model;

public class InsertionSort extends AlgoritmoOrdenacao {
    
    public InsertionSort(int tamanho) {
        super(tamanho);
    }
    
    @Override
    public String getNome() {
        return "Insertion Sort";
    }
    
    @Override
    public int[] ordenar() {
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
}
