import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Mochila {
    // Lista de itens disponíveis
    private List<Item> itens = new ArrayList<>();
    private int capacidade;
    
    // Métodos de acesso
    public List<Item> getItens() {
    	return this.itens;
    }
    
    public int getCapacidade() {
    	return this.capacidade;
    }
    
    /**
     * Construtor por arquivo txt
     * 
     * @param arquivo
     * @throws FileNotFoundException
     */
    public Mochila(File arquivo) throws FileNotFoundException {
    	Scanner scanner = new Scanner(arquivo);
    	
    	if (scanner.hasNext())
    		this.capacidade = scanner.nextInt(); // Obtem a capacidade da mochila (Primeira linha do txt)
    	
    	if (scanner.hasNext())
    		scanner.nextInt(); // Obtem o tamanho do array (Usando list, essa informação fica desnecessária)
    	
    	while (scanner.hasNext()) {
    		scanner.nextLine();
    		int peso = scanner.nextInt();
    		int valor = scanner.nextInt();
    		
    		Item item = new Item("",peso,valor);
    		
    		itens.add(item);
    	}
    }
}
