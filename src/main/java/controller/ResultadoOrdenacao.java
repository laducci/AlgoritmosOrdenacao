package controller;

public class ResultadoOrdenacao {
    private String nomeAlgoritmo;
    private long tempoExecucao;
    private boolean ordenadoCorretamente;
    
    public ResultadoOrdenacao(String nomeAlgoritmo, long tempoExecucao, boolean ordenadoCorretamente) {
        this.nomeAlgoritmo = nomeAlgoritmo;
        this.tempoExecucao = tempoExecucao;
        this.ordenadoCorretamente = ordenadoCorretamente;
    }
    
    public String getNomeAlgoritmo() {
        return nomeAlgoritmo;
    }
    
    public long getTempoExecucao() {
        return tempoExecucao;
    }
    
    public boolean isOrdenadoCorretamente() {
        return ordenadoCorretamente;
    }
}
