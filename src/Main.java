import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de itensMochila com nome, peso e valor
        List<Item> itensMochila = new ArrayList<>();
        itensMochila.add(new Item("Cálice", 3, 6));
        itensMochila.add(new Item("Livro", 4, 8));
        itensMochila.add(new Item("Lanterna", 2, 5));
        itensMochila.add(new Item("Chave", 1, 3));
        itensMochila.add(new Item("Bolsa", 5, 9));
        itensMochila.add(new Item("Celular", 1, 7));
        itensMochila.add(new Item("Carteira", 1, 4));
        itensMochila.add(new Item("Relógio", 2, 6));
        itensMochila.add(new Item("Óculos", 1, 5));
        itensMochila.add(new Item("Faca", 2, 4));
        itensMochila.add(new Item("Toalha", 3, 5));
        itensMochila.add(new Item("Sapato", 4, 7));
        itensMochila.add(new Item("Caderno", 2, 3));
        itensMochila.add(new Item("Fone de Ouvido", 1, 6));
        int capacidadeMochila = 4;
        
        // Parâmetros do ILS
        int criterioDeParadaDoILS = 50;
        int criterioDeParadaDaBuscaLocal = 100;
        int tamanhoMaximoPertubação = 8;

        // Iniciação da mochila com os itensMochila
        Mochila mochila = new Mochila(itensMochila, capacidadeMochila);
        // Iniciação do ils com a mochila e o criterio de parada
        MetodosILS ils = new MetodosILS(mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal, tamanhoMaximoPertubação);
        // Encontrar e exibir a solução
        ils.exibirSolucao(ils.encontrarSolucao());
    }
}
