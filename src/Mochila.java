import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Mochila {
    // Lista de itens disponíveis
    private List<Item> itens = new ArrayList<>();
    private Item[] ItensV;
    private int capacidade;
    private int TotalItens;
    
    // Métodos de acesso
    public List<Item> getItens() {
    	return this.itens;
    }
    
    public int getCapacidade() {
    	return this.capacidade;
    }
    
    public Item getItemV(int Posição) {
    	
		return ItensV[Posição];
    		
    }
    
    public int getTotalItens() {
    	return this.TotalItens;
    }
    
    
    
    /**
     * Construtor por arquivo txt
     * 
     * @param arquivo
     * @throws FileNotFoundException
     */
    public Mochila(File arquivo) throws FileNotFoundException {
    	Scanner scanner = new Scanner(arquivo);
    	int i = 0;
    	
    	if (scanner.hasNext())
    		this.capacidade = scanner.nextInt(); // Obtem a capacidade da mochila (Primeira linha do txt)
    	
    	if (scanner.hasNext())
    		TotalItens = scanner.nextInt();
    		ItensV = new Item[TotalItens];
    		//scanner.nextInt(); // Obtem o tamanho do array (Usando list, essa informação fica desnecessária)
    	
    	while (scanner.hasNext()) {
    		scanner.nextLine();
    		int peso = scanner.nextInt();
    		int valor = scanner.nextInt();
    		
    		Item item = new Item("-Item " + i,peso,valor);
    		
    		itens.add(item);
    		ItensV[i] = item;
    		i++;
    	}
    	scanner.close();
    }
}
