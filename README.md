<!-- Caracter Icon -->
──────▄▀▄─────▄▀▄  
─────▄█░░▀▀▀▀▀░░█▄  
─▄▄──█░░░░░░░░░░░█──▄▄  
█▄▄█─█░░▀░░┬░░▀░░█─█▄▄█  

<!-- Animated img -->
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=FF00FF&height=120&section=header"/>

<!-- Animated text -->
<div align="center">
  <img src="https://readme-typing-svg.herokuapp.com/?color=FF00FF&size=35&center=true&width=290&lines=PROJECT;NAME"/>
</div>

<h2 align="right">1.1. INTRODUCTION 📰</h2>

Pseudocódigo

```text
INÍCIO
    // Classe Item para representar um item com nome, peso e valor
    CLASSE Item
        ATRIBUTOS:
            nome
            peso
            valor
        MÉTODO CONSTRUTOR:
            Item(nome, peso, valor)
    FIM CLASSE

    // Classe Mochila para representar a mochila com uma lista de itens e sua capacidade
    CLASSE Mochila
        ATRIBUTOS:
            listaDeItens
            capacidade
        MÉTODOS:
            getItens()
            getCapacidade()
        MÉTODO CONSTRUTOR:
            Mochila(listaDeItens, capacidade)
    FIM CLASSE

    // Classe MetodosILS para implementar o algoritmo ILS
    CLASSE MetodosILS
        ATRIBUTOS:
            mochila
            criterioDeParadaDoILS
            criterioDeParadaDaBuscaLocal
            random = GERAR_NUMERO_ALEATORIO
        
        MÉTODO CONSTRUTOR:
            MetodosILS(mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal)
        
        // Método para verificar a solução na mochila
        MÉTODO verificarMochila(solucao)
            pesoTotal = 0
            valorTotal = 0
            PARA i = 0 ATÉ tamanho(solucao) FAÇA
                SE solucao[i] == 1 ENTÃO
                    pesoTotal += mochila.getItens()[i].peso
                    valorTotal += mochila.getItens()[i].valor
                FIM SE
            FIM PARA
            SE pesoTotal <= mochila.getCapacidade() ENTÃO
                RETORNAR valorTotal
            SENÃO
                RETORNAR 0
            FIM SE
        FIM MÉTODO

        // Método de busca local para melhorar a solução
        MÉTODO buscaLocal(solucao)
            melhorSolucao = COPIAR(solucao)
            melhorValor = verificarMochila(melhorSolucao)
            PARA i = 0 ATÉ criterioDeParadaDaBuscaLocal FAÇA
                novaSolucao = COPIAR(melhorSolucao)
                indice = GERAR_NUMERO_ALEATORIO(tamanho(novaSolucao))
                novaSolucao[indice] = 1 - novaSolucao[indice] // Alternar valor de 0 para 1 ou de 1 para 0
                novoValor = verificarMochila(novaSolucao)
                SE novoValor > melhorValor ENTÃO
                    melhorSolucao = novaSolucao
                    melhorValor = novoValor
                FIM SE
            FIM PARA
            RETORNAR melhorSolucao
        FIM MÉTODO

        // Método de perturbação para escapar de ótimos locais
        MÉTODO perturbacao(solucao)
            solucaoPerturbada = COPIAR(solucao)
            tamanhoPerturbacao = GERAR_NUMERO_ALEATORIO(tamanho(solucao) / 2) + 1
            PARA i = 0 ATÉ tamanhoPerturbacao FAÇA
                indice = GERAR_NUMERO_ALEATORIO(tamanho(solucaoPerturbada))
                solucaoPerturbada[indice] = 1 - solucaoPerturbada[indice]
            FIM PARA
            RETORNAR solucaoPerturbada
        FIM MÉTODO

        // Método ILS que combina busca local e perturbação
        MÉTODO encontrarSolucao()
            solucaoAtual = NOVA_SOLUCAO(tamanho(mochila.getItens()))
            melhorSolucao = buscaLocal(solucaoAtual)
            PARA i = 0 ATÉ criterioDeParadaDoILS FAÇA
                solucaoPerturbada = perturbacao(melhorSolucao)
                novaSolucao = buscaLocal(solucaoPerturbada)
                SE verificarMochila(novaSolucao) > verificarMochila(melhorSolucao) ENTÃO
                    melhorSolucao = novaSolucao
                FIM SE
            FIM PARA
            RETORNAR melhorSolucao
        FIM MÉTODO

        // Método para exibir a solução final
        MÉTODO exibirSolucao(solucao)
            pesoTotal = 0
            valorTotal = 0
            EXIBIR "Itens na mochila:"
            PARA i = 0 ATÉ tamanho(solucao) FAÇA
                SE solucao[i] == 1 ENTÃO
                    item = mochila.getItens()[i]
                    EXIBIR item.nome + " (Peso: " + item.peso + ", Valor: " + item.valor + ")"
                    pesoTotal += item.peso
                    valorTotal += item.valor
                FIM SE
            FIM PARA
            EXIBIR "Peso total: " + pesoTotal
            EXIBIR "Valor total: " + valorTotal
        FIM MÉTODO
    FIM CLASSE

    // Função principal para executar o programa
    INÍCIO_MAIN
        // Criação da lista de itens
        LISTA itens = NOVA_LISTA()
        itens.ADICIONAR(Item("Garfo", 1, 2))
        itens.ADICIONAR(Item("Cálice", 3, 6))
        itens.ADICIONAR(Item("Livro", 4, 8))
        itens.ADICIONAR(Item("Lanterna", 2, 5))
        itens.ADICIONAR(Item("Chave", 1, 3))
        itens.ADICIONAR(Item("Bolsa", 5, 9))
        itens.ADICIONAR(Item("Celular", 1, 7))
        itens.ADICIONAR(Item("Carteira", 1, 4))
        itens.ADICIONAR(Item("Relógio", 2, 6))
        itens.ADICIONAR(Item("Óculos", 1, 5))
        itens.ADICIONAR(Item("Faca", 2, 4))
        itens.ADICIONAR(Item("Toalha", 3, 5))
        itens.ADICIONAR(Item("Sapato", 4, 7))
        itens.ADICIONAR(Item("Caderno", 2, 3))
        itens.ADICIONAR(Item("Fone de Ouvido", 1, 6))

        // Definição da capacidade da mochila e critérios de parada
        capacidade = 5
        criterioDeParadaDoILS = 14
        criterioDeParadaDaBuscaLocal = 100

        // Criação da instância da Mochila e do MetodosILS
        mochila = NOVA_INSTANCIA_Mochila(itens, capacidade)
        ils = NOVA_INSTANCIA_MetodosILS(mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal)

        // Encontrar e exibir a solução final
        solucaoFinal = ils.encontrarSolucao()
        ils.exibirSolucao(solucaoFinal)
    FIM_MAIN

FIM
```

<h2 align="right">1.2. DESCRIPTION 📝</h2>

Este repositório contém um estudo sobre o problema da mochila utilizando a Metaheurística de Busca Local Iterada (ILS), desenvolvido durante o curso de Bacharelado em Sistemas de Informação no Instituto Federal Fluminense.

<h2 align="right">1.3. TECHNOLOGIES 💻</h2>

<div style="display: inline_block">
  
  <!-- Cloud hosting and databases -->
  ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=FFFFFF&color=FF00FF)&nbsp; 
  ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=FFFFFF&color=FF00FF)&nbsp;
  
  <!-- Languages -->
  ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=FFFFFF&color=FF00FF)&nbsp;
  ![Markdown](https://img.shields.io/badge/markdown-%23000000.svg?style=for-the-badge&logo=markdown&logoColor=FFFFFF&color=FF00FF)&nbsp;
  
  <!-- Frameworks -->
  
  <!-- Softwares -->
  ![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=FFFFFF&color=FF00FF)&nbsp;

  <!-- Others -->
  
</div>

<h2 align="right" id="ponto1">1.4. HOW TO USE 💡</h2>
<p align="right">Use the following commands (if there are commands) by <kbd>CTRL</kbd>+<kbd>V</kbd> where necessary</p>

📌 Baixe o codigo e rode pela sua IDE

<h2 align="right">1.5. OTHER REPOSITORIES 📘</h2>

<div>
  <img width="49%" src="https://github-readme-stats.vercel.app/api/pin/?username=IvanilsoDaSilva&repo=sistema-bancario-frontend&bg_color=FF00FF&title_color=FFFFFF&text_color=FFFFFF&icon_color=FFFFFF&border_color=FFFFFF"/>
  <img width="49%" src="https://github-readme-stats.vercel.app/api/pin/?username=IvanilsoDaSilva&repo=sistema-bancario-backend&bg_color=FFFFFF&title_color=FF00FF&text_color=FF00FF&icon_color=FF00FF&border_color=FF00FF"/>
  <img width="49%" src="https://github-readme-stats.vercel.app/api/pin/?username=IvanilsoDaSilva&repo=iff-bsi&bg_color=FFFFFF&title_color=FF00FF&text_color=FF00FF&icon_color=FF00FF&border_color=FF00FF"/>
  <img width="49%" src="https://github-readme-stats.vercel.app/api/pin/?username=IvanilsoDaSilva&repo=git-commands&bg_color=FF00FF&title_color=FFFFFF&text_color=FFFFFF&icon_color=FFFFFF&border_color=FFFFFF"/>
</div>

<a href="https://github.com/IvanilsoDaSilva?tab=repositories">More...</a>

<!-- Animated img -->
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=FF00FF&height=120&section=footer"/>
