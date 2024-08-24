import java.util.List;

public class Mochila {
    // Lista de itens disponíveis
    private List<Item> itens;
    private int capacidade;

    // Parâmetros do ILS
    private int maxBuscaLocal = 100;
    
    // Métodos de acesso
    public List<Item> getItens() {
    	return this.itens;
    }
    
    public int getCapacidade() {
    	return this.capacidade;
    }
    
    public int getMaxBuscaLocal() {
    	return this.maxBuscaLocal;
    }
    
    // Método construtor
    public Mochila(List<Item> itens, int capacidade) {
        this.itens = itens;
        this.capacidade = capacidade;
    }
}
