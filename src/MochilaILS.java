import java.util.*;

public class MochilaILS {
    // Lista de itens disponíveis
    private List<Item> itens;
    private int capacidade;

    // Parâmetros do ILS
    private int maxIteracoes = 1000;
    private int maxBuscaLocal = 100;
    
    // Métodos de acesso
    public List<Item> getItens() {
    	return this.itens;
    }
    
    public int getCapacidade() {
    	return this.capacidade;
    }
    
    public int getMaxIteracoes() {
    	return this.maxIteracoes;
    }
    
    public int getMaxBuscaLocal() {
    	return this.maxBuscaLocal;
    }
    
    // Método construtor
    public MochilaILS(List<Item> itens, int capacidade) {
        this.itens = itens;
        this.capacidade = capacidade;
    }
}
