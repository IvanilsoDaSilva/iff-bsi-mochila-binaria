package main.java.com.mochilabinaria;

class Item {
    String nome;
    int peso;
    int valor;

    /**
     * Construtor da classe Item
     * 
     * @param nome Nome do item
     * @param peso Peso do item
     * @param valor Valor ou ganho do item
     */
    public Item(String nome, int peso, int valor) {
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
    }
}