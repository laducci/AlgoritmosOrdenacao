package model;

public abstract class AlgoritmoOrdenacao {
    
    protected int[] lista;
    protected int tamanho;
    
    public AlgoritmoOrdenacao(int tamanho) {
        this.lista = new int[tamanho];
        this.tamanho = tamanho;
    }
    
    public void inserir(int[] valores) {
        this.tamanho = Math.min(valores.length, lista.length);
        for (int i = 0; i < tamanho; i++) {
            lista[i] = valores[i];
        }
    }
    
    public abstract int[] ordenar(); // metodo abstrado pra obrigar tds a criar com sua propria logica
    
    public abstract String getNome(); // vamos precisar para pegar o nome no controller
    
    public boolean estaOrdenada() { // metodo pra dizer se ta ordenado
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
    
    protected void swap(int i, int j) { // metodo de troca de posicoes
        int guardar = lista[i];
        lista[i] = lista[j];
        lista[j] = guardar;
    }
}
