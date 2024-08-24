import java.util.ArrayList;
import java.util.List;

public class Main {
	// Exemplo de uso
    public static void main(String[] args) {
        // Definição dos itens
        List<Item> itens = new ArrayList<>();
        itens.add(new Item("Garfo", 1, 2));
        itens.add(new Item("Cálice", 3, 6));
        itens.add(new Item("Livro", 4, 8));
        itens.add(new Item("Lanterna", 2, 5));
        itens.add(new Item("Chave", 1, 3));
        itens.add(new Item("Bolsa", 5, 9));
        itens.add(new Item("Celular", 1, 7));
        itens.add(new Item("Carteira", 1, 4));
        itens.add(new Item("Relógio", 2, 6));
        itens.add(new Item("Óculos", 1, 5));
        itens.add(new Item("Faca", 2, 4));
        itens.add(new Item("Toalha", 3, 5));
        itens.add(new Item("Sapato", 4, 7));
        itens.add(new Item("Caderno", 2, 3));
        itens.add(new Item("Fone de Ouvido", 1, 6));

        int capacidade = 5;

        MochilaILS mochila = new MochilaILS(itens, capacidade);
        //int[] solucao = mochila.buscaLocalIterativa();
        MetodosILS ils = new MetodosILS(mochila);
        ils.exibirSolucao(ils.buscaLocalIterativa());
    }
}
