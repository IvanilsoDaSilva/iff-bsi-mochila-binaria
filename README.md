<!-- Caracter Icon -->
──────▄▀▄─────▄▀▄  
─────▄█░░▀▀▀▀▀░░█▄  
─▄▄──█░░░░░░░░░░░█──▄▄  
█▄▄█─█░░▀░░┬░░▀░░█─█▄▄█  

<!-- Animated img -->
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=FF00FF&height=120&section=header"/>

<!-- Animated text -->
<div align="center">
  <img src="https://readme-typing-svg.herokuapp.com/?color=FF00FF&size=35&center=true&width=290&lines=IFF;BSI;MOCHILA;BINARIA"/>
</div>

<h2 align="right">1.1. INTRODUCTION 📰</h2>

### Pseudocódigo simples

```
INÍCIO
    CLASSE Item
        ATRIBUTOS: nome, peso, valor
        MÉTODO CONSTRUTOR: Item(nome, peso, valor)
    FIM CLASSE

    CLASSE Mochila
        ATRIBUTOS: listaDeItens, capacidade
        MÉTODOS: getItens(), getCapacidade()
        MÉTODO CONSTRUTOR: Mochila(listaDeItens, capacidade)
    FIM CLASSE

    CLASSE MetodosILS
        ATRIBUTOS:
            mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal, tamanhoMaximoPerturbacao, random
        MÉTODO CONSTRUTOR: MetodosILS(
            mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal, tamanhoMaximoPerturbacao
        )
        MÉTODO verificarMochila(solucao) FIM MÉTODO
        MÉTODO buscaLocal(solucao) FIM MÉTODO
        MÉTODO perturbacao(solucao) FIM MÉTODO
        MÉTODO encontrarSolucao() FIM MÉTODO
        MÉTODO exibirSolucao(solucao) FIM MÉTODO
    FIM CLASSE

    INÍCIO_MAIN
        LISTA itens = NOVA_LISTA()
        capacidade = 6
        criterioDeParadaDoILS = 100
        criterioDeParadaDaBuscaLocal = 100
        tamanhoMaximoPerturbacao = 8
        mochila = NOVA_INSTANCIA_Mochila(itens, capacidade)
        ils = NOVA_INSTANCIA_MetodosILS(
            mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal, tamanhoMaximoPerturbacao
        )
        ils.exibirSolucao(ils.encontrarSolucao())
    FIM_MAIN
FIM
```

### Pseudocódigo completo

```text
INÍCIO

    CLASSE Item
        ATRIBUTOS:
            nome
            peso
            valor
        MÉTODO CONSTRUTOR:
            Item(nome, peso, valor)
    FIM CLASSE

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

    CLASSE MetodosILS
        ATRIBUTOS:
            mochila
            criterioDeParadaDoILS
            criterioDeParadaDaBuscaLocal
            tamanhoMaximoPertubação
            random = GERAR_NUMERO_ALEATORIO
        
        MÉTODO CONSTRUTOR:
            MetodosILS(mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal, tamanhoMaximoPertubação)
        
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

        MÉTODO buscaLocal(solucao)
            melhorSolucao = COPIAR(solucao)
            melhorValor = verificarMochila(melhorSolucao)
            PARA i = 0 ATÉ criterioDeParadaDaBuscaLocal FAÇA
                novaSolucao = COPIAR(melhorSolucao)
                indice = GERAR_NUMERO_ALEATORIO(tamanho(novaSolucao))
                novaSolucao[indice] = 1 - novaSolucao[indice]
                novoValor = verificarMochila(novaSolucao)
                SE novoValor > melhorValor ENTÃO
                    melhorSolucao = novaSolucao
                    melhorValor = novoValor
                FIM SE
            FIM PARA
            RETORNAR melhorSolucao
        FIM MÉTODO

        MÉTODO perturbacao(solucao)
            solucaoPerturbada = COPIAR(solucao)
            tamanhoPerturbacao = GERAR_NUMERO_ALEATORIO(tamanhoMaximoPertubação) + 1
            PARA i = 0 ATÉ tamanhoPerturbacao FAÇA
                indice = GERAR_NUMERO_ALEATORIO(tamanho(solucaoPerturbada))
                solucaoPerturbada[indice] = 1 - solucaoPerturbada[indice]
            FIM PARA
            RETORNAR solucaoPerturbada
        FIM MÉTODO

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
            EXIBIR "Peso: " + pesoTotal
            EXIBIR "Valor: " + valorTotal
            EXIBIR "Criterio de parada da pertubação: " + criterioDeParadaDoILS
            EXIBIR "Criterio de parada da busca local: " + criterioDeParadaDaBuscaLocal
            EXIBIR "Tamanho maximo da pertubação: " + tamanhoMaximoPertubação
        FIM MÉTODO
    FIM CLASSE

    INÍCIO_MAIN
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

        capacidade = 5
        criterioDeParadaDoILS = 100
        criterioDeParadaDaBuscaLocal = 100
        tamanhoMaximoPertubação = 8

        mochila = NOVA_INSTANCIA_Mochila(itens, capacidade)
        ils = NOVA_INSTANCIA_MetodosILS(mochila, criterioDeParadaDoILS, criterioDeParadaDaBuscaLocal, tamanhoMaximoPertubação)

        solucaoFinal = ils.encontrarSolucao()
        ils.exibirSolucao(solucaoFinal)
    FIM_MAIN

FIM
```

### Explicação

- Classe Item: Representa um item com atributos nome, peso, e valor.
- Classe Mochila: Contém a lista de itens e a capacidade da mochila, além de métodos para acessar essas informações.
- Classe MetodosILS: Implementa o algoritmo Iterated Local Search (ILS) com os métodos principais:
  - verificarMochila: Avalia o valor da solução considerando as restrições de capacidade.
  - buscaLocal: Melhora a solução atual alterando os itens na mochila.
  - perturbacao: Introduz mudanças na solução para evitar ótimos locais.
  - encontrarSolucao: Aplica a combinação de busca local e perturbação para encontrar a melhor solução.
  - exibirSolucao: Exibe os itens selecionados na mochila, juntamente com o peso e o valor total.
- Função INÍCIO_MAIN: Cria a lista de itens, define a capacidade da mochila, os critérios de parada, e executa o algoritmo ILS, exibindo a solução final.
  - capacidade: Define o peso máximo que a mochila pode carregar. A solução precisa respeitar esse limite para ser válida.
  - criterioDeParadaDoILS: Estabelece o número máximo de iterações que o algoritmo ILS realizará antes de parar. Isso controla a duração da busca.
  - criterioDeParadaDaBuscaLocal: Indica quantas iterações de busca local serão realizadas para melhorar a solução atual antes da pertubação. Mais iterações podem refinar a solução.
  - tamanhoMaximoPertubação: Determina o número máximo de mudanças que podem ser feitas na solução durante a fase de perturbação. Isso ajuda a explorar novas soluções e evitar ficar preso em soluções subótimas.

### Entrada 

| Nome              | Peso | Valor |
|-------------------|------|-------|
| Garfo             | 1    | 2     |
| Cálice            | 3    | 6     |
| Livro             | 4    | 8     |
| Lanterna          | 2    | 5     |
| Chave             | 1    | 3     |
| Bolsa             | 5    | 9     |
| Celular           | 1    | 7     |
| Carteira          | 1    | 4     |
| Relógio           | 2    | 6     |
| Óculos            | 1    | 5     |
| Faca              | 2    | 4     |
| Toalha            | 3    | 5     |
| Sapato            | 4    | 7     |
| Caderno           | 2    | 3     |
| Fone de Ouvido    | 1    | 6     |


### Melhores soluções

Peso máximo: 4
```
Itens na mochila:
Celular (Peso: 1, Valor: 7)
Carteira (Peso: 1, Valor: 4)
Óculos (Peso: 1, Valor: 5)
Fone de Ouvido (Peso: 1, Valor: 6)

Peso: 4
Valor: 22
Criterio de parada da pertubação: 50
Criterio de parada da busca local: 100
Tamanho maximo da pertubação: 8

```

Peso máximo: 5
```
Itens na mochila:
Chave (Peso: 1, Valor: 3)
Celular (Peso: 1, Valor: 7)
Carteira (Peso: 1, Valor: 4)
Óculos (Peso: 1, Valor: 5)
Fone de Ouvido (Peso: 1, Valor: 6)

Peso: 5
Valor: 25
Criterio de parada da pertubação: 100
Criterio de parada da busca local: 100
Tamanho maximo da pertubação: 8
```

Peso máximo: 6
```
Itens na mochila:
Celular (Peso: 1, Valor: 7)
Carteira (Peso: 1, Valor: 4)
Relógio (Peso: 2, Valor: 6)
Óculos (Peso: 1, Valor: 5)
Fone de Ouvido (Peso: 1, Valor: 6)

Peso: 6
Valor: 28
Criterio de parada da pertubação: 50
Criterio de parada da busca local: 100
Tamanho maximo da pertubação: 8
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
  <img width="49%" src="https://github-readme-stats.vercel.app/api/pin/?username=IvanilsoDaSilva&repo=iff-bsi-sistema-bancario-frontend&bg_color=FF00FF&title_color=FFFFFF&text_color=FFFFFF&icon_color=FFFFFF&border_color=FFFFFF"/>
  <img width="49%" src="https://github-readme-stats.vercel.app/api/pin/?username=IvanilsoDaSilva&repo=iff-bsi-sistema-bancario-backend&bg_color=FFFFFF&title_color=FF00FF&text_color=FF00FF&icon_color=FF00FF&border_color=FF00FF"/>
  <img width="49%" src="https://github-readme-stats.vercel.app/api/pin/?username=IvanilsoDaSilva&repo=iff-bsi&bg_color=FFFFFF&title_color=FF00FF&text_color=FF00FF&icon_color=FF00FF&border_color=FF00FF"/>
  <img width="49%" src="https://github-readme-stats.vercel.app/api/pin/?username=IvanilsoDaSilva&repo=git-commands&bg_color=FF00FF&title_color=FFFFFF&text_color=FFFFFF&icon_color=FFFFFF&border_color=FFFFFF"/>
</div>

<a href="https://github.com/IvanilsoDaSilva?tab=repositories">More...</a>

<!-- Animated img -->
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=FF00FF&height=120&section=footer"/>
