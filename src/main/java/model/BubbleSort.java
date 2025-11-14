package model;

public class BubbleSort extends AlgoritmoOrdenacao {
    
    public BubbleSort(int tamanho) {
        super(tamanho);
    }
    
    @Override
    public String getNome() {
        return "Bubble Sort";
    }
    
    @Override
    public int[] ordenar() {
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
}
