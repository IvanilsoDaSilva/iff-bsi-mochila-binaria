import java.util.*;

public class MetodosILS {
	private MochilaILS mochila;
    private Random random = new Random();
    
    public MetodosILS(MochilaILS mochila) {
    	this.mochila = mochila;
    }
    
	// Função de avaliação (fitness)
    private int avaliar(int[] solucao) {
        int pesoTotal = 0;
        int valorTotal = 0;
        
        for (int i = 0; i < solucao.length; i++) {
            if (solucao[i] == 1) {
                pesoTotal += this.mochila.getItens().get(i).peso;
                valorTotal += this.mochila.getItens().get(i).valor;
            }
        }
        return pesoTotal <= this.mochila.getCapacidade() ? valorTotal : 0;
    }

    // Busca local: tenta melhorar a solução alterando um item de cada vez
    private int[] buscaLocal(int[] solucao) {
        int[] melhorSolucao = Arrays.copyOf(solucao, solucao.length);
        int melhorValor = avaliar(melhorSolucao);
        for (int i = 0; i < this.mochila.getMaxBuscaLocal(); i++) {
            int[] novaSolucao = Arrays.copyOf(melhorSolucao, melhorSolucao.length);
            int indice = random.nextInt(novaSolucao.length);
            novaSolucao[indice] = 1 - novaSolucao[indice]; // Alterna o valor de 0 para 1 ou de 1 para 0

            int novoValor = avaliar(novaSolucao);
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
        int tamanhoPerturbacao = random.nextInt(solucaoPerturbada.length / 2) + 1;

        for (int i = 0; i < tamanhoPerturbacao; i++) {
            int indice = random.nextInt(solucaoPerturbada.length);
            solucaoPerturbada[indice] = 1 - solucaoPerturbada[indice];
        }

        return solucaoPerturbada;
    }

    // ILS: combina a busca local e a perturbação
    public int[] buscaLocalIterativa() {
        int[] solucaoAtual = new int[this.mochila.getItens().size()];
        int[] melhorSolucao = buscaLocal(solucaoAtual);

        for (int i = 0; i < this.mochila.getMaxIteracoes(); i++) {
            int[] solucaoPerturbada = perturbacao(melhorSolucao);
            int[] novaSolucao = buscaLocal(solucaoPerturbada);

            if (avaliar(novaSolucao) > avaliar(melhorSolucao)) {
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
                Item item = this.mochila.getItens().get(i);
                System.out.println(item.nome + " (Peso: " + item.peso + ", Valor: " + item.valor + ")");
                pesoTotal += item.peso;
                valorTotal += item.valor;
            }
        }
        System.out.println("Peso total: " + pesoTotal);
        System.out.println("Valor total: " + valorTotal);
    }
}
