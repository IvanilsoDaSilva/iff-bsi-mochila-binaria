package main.java.com.mochilabinaria;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Mochila {
    private Item[] itens = new Item[0];
    private int capacidade;
    
    /**
     * Obtem a lista de itens dentro da mochila
     * 
     * @return Array Item dos itens presentes na mochila
     */
    public Item[] getItens() {
    	return this.itens;
    }
    
    /**
     * Obtem a capacidade de peso da mochila
     * 
     * @return Valor maximo de peso da mochila
     */
    public int getCapacidade() {
    	return this.capacidade;
    }
    
    /**
     * Construtor por arquivo txt
     * 
     * @param arquivo Arquivo em txt que atende os criterios para preenchimento
     * @throws FileNotFoundException Excecao caso o arquivo não for encontrado
     */
    public Mochila(File arquivo) throws FileNotFoundException {
    	Scanner scanner = new Scanner(arquivo);
    	
    	if (scanner.hasNext())
    		this.capacidade = scanner.nextInt(); // Obtem a capacidade da mochila (Primeira linha do txt)
    	
    	if (scanner.hasNext())
    		this.itens = new Item[scanner.nextInt()]; // Obtem o tamanho do array (Usando list, essa informação fica desnecessária)
    	
    	int cont = 0;
    	while (scanner.hasNext()) {
    		scanner.nextLine();
    		int peso = scanner.nextInt();
    		int valor = scanner.nextInt();
    		
    		Item item = new Item("Item "+cont,peso,valor);
    		
    		itens[cont] = item;
    		cont++;
    	}
    }
}
