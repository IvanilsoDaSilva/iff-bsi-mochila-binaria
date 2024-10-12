package main.java.com.mochilabinaria;

import java.util.*;

public class MetodosILS {
	private Mochila mochila;
	private int criterioDeParadaDoILS;
	private int criterioDeParadaDaBuscaLocal;
	private int tamanhoPertubação;
    private Random random = new Random();
    
    // Construtor da classe
    public MetodosILS(Mochila mochila, int criterioDeParadaDoILS, int criterioDeParadaDaBuscaLocal, int tamanhoPertubação) {
    	this.mochila = mochila;
    	this.criterioDeParadaDoILS = criterioDeParadaDoILS;
    	this.criterioDeParadaDaBuscaLocal = criterioDeParadaDaBuscaLocal;
    	this.tamanhoPertubação = tamanhoPertubação;
    }
    
	// Função de avaliação da mochila
    private int verificarMochila(int[] solucao) {
        int pesoTotal = 0;
        int valorTotal = 0;
        
        for (int i = 0; i < solucao.length; i++) {
            if (solucao[i] == 1) {
                pesoTotal += this.mochila.getItens()[i].peso;
                valorTotal += this.mochila.getItens()[i].valor;
            }
        }
        return pesoTotal <= this.mochila.getCapacidade() ? valorTotal : 0;
    }

    // Busca local: tenta melhorar a solução alterando um item de cada vez
    private int[] buscaLocal(int[] solucao) {
        int[] melhorSolucao = Arrays.copyOf(solucao, solucao.length);
        int melhorValor = verificarMochila(melhorSolucao);
        
        for (int i = 0; i < criterioDeParadaDaBuscaLocal; i++) {
            int[] novaSolucao = Arrays.copyOf(melhorSolucao, melhorSolucao.length);
            int indice = random.nextInt(novaSolucao.length);
            novaSolucao[indice] = 1 - novaSolucao[indice]; // Alterna o valor de 0 para 1 ou de 1 para 0

            int novoValor = verificarMochila(novaSolucao);
            if (novoValor > melhorValor) {
                melhorSolucao = novaSolucao;
                melhorValor = novoValor;
            }
        }
        return melhorSolucao;
    }

    // Perturbação: modifica a solução atual para escapar de ótimos locais
    private int[] perturbacao(int[] solucao) {
        int[] solucaoPerturbada = Arrays.copyOf(solucao, solucao.length);
        /*
         * Define quantos elementos da solução serão 
         * alterados (perturbados) aleatoriamente.
         * Neste caso de pelo menos um até a metade de 
         * elementos da solução
         */
//        int tamanhoPerturbacao = random.nextInt(tamanhoMaximoPertubação) + 1;

        for (int i = 0; i < this.tamanhoPertubação; i++) {
        	/*
        	 * Inverte todos os elementos na faixa do tamanho da
        	 * pertubação
        	 */
            int indice = random.nextInt(solucaoPerturbada.length);
            solucaoPerturbada[indice] = 1 - solucaoPerturbada[indice];
        }

        return solucaoPerturbada;
    }

    // ILS: combina a busca local e a perturbação
    public int[] encontrarSolucao() {
    	/*
    	 * Array com base na lista de itens que podem entrar na mochila
    	 * 0 significa que o item não esta na mochila
    	 * 1 significa que o item esta na mochila
    	 */
        int[] solucaoAtual = new int[this.mochila.getItens().length];
        int[] melhorSolucao = buscaLocal(solucaoAtual);

        /*
         * Repete a pertubação e busca local ate atender
         * o criterio de parada da ILS, nesse caso uma quantidade
         * de interações
         */
        for (int i = 0; i < criterioDeParadaDoILS; i++) {
            int[] solucaoPerturbada = perturbacao(melhorSolucao);
            int[] novaSolucao = buscaLocal(solucaoPerturbada);
            
            if((i*100/criterioDeParadaDoILS) != (i - 1)*100/criterioDeParadaDoILS) {
          	  System.out.println("Progresso: " + (i*100/criterioDeParadaDoILS) + "%");
            }

            // Criterio de aceitação
            if (verificarMochila(novaSolucao) > verificarMochila(melhorSolucao)) {
                melhorSolucao = novaSolucao;
            }
        }

        return melhorSolucao;
    }

    // Exibe a solução final
    public final void exibirSolucao(int[] solucao) {
        int pesoTotal = 0;
        int valorTotal = 0;
        System.out.println("Itens na mochila:");
        for (int i = 0; i < solucao.length; i++) {
            if (solucao[i] == 1) {
                Item item = this.mochila.getItens()[i];
                System.out.println(item.nome + " (Peso: " + item.peso + ", Valor: " + item.valor + ")");
                pesoTotal += item.peso;
                valorTotal += item.valor;
            }
        }
        System.out.println();
        System.out.println("Peso: " + pesoTotal);
        System.out.println("Valor: " + valorTotal);
        System.out.println("Criterio de parada da pertubação: " + criterioDeParadaDoILS);
        System.out.println("Criterio de parada da busca local: " + criterioDeParadaDaBuscaLocal);
        System.out.println("Tamanho da pertubação: " + tamanhoPertubação);
    }
}
