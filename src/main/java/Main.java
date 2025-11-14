import controller.OrdenacaoController;
import controller.ResultadoOrdenacao;
import view.OrdenacaoView;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        
        OrdenacaoController controller = new OrdenacaoController();
        OrdenacaoView view = new OrdenacaoView();

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
            view.exibirInicio(nomeArquivo);

            try {
                // Lê os dados do arquivo
                int[] listaNumeros = view.lerArquivo("src/main/resources/" + nomeArquivo);
                
                // Executa todos os algoritmos
                ResultadoOrdenacao[] resultados = controller.executarTodosAlgoritmos(listaNumeros);
                
                // Exibe os resultados
                view.exibirResultados(resultados);

            } catch (FileNotFoundException e) {
                view.exibirErro("arq não encontrado: " + nomeArquivo);
            }
        }
    }
}
