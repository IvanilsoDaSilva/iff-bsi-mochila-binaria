import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
    	File arquivo = new File(System.getProperty("user.dir")+"\\src\\input.txt");
      
    	// Parâmetros do ILS
    	int criterioDeParadaDoILS = 1000;
    	int criterioDeParadaDaBuscaLocal = 1000;
    	int tamanhoMaximoPertubação = 2500;

    	// Iniciação da mochila com os itensMochila
    	Mochila mochila = new Mochila(arquivo);
    	// Iniciação do ils com a mochila e o criterio de parada
    	//MetodosILS ils = new MetodosILS(mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal, tamanhoMaximoPertubação);
    	MetodoILS_Vetor ils = new MetodoILS_Vetor(mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal, tamanhoMaximoPertubação);
    	// Encontrar e exibir a solução
    	ils.exibirSolucao(ils.encontrarSolucao());
    }
}
