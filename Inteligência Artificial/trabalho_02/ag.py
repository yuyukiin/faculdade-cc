import random
from cromossomo import Cromossomo
from util import Util

class AG:
    @staticmethod
    def gerar_populacao(populacao, tamanho_populacao, estado_final):
        for i in range(tamanho_populacao):
            populacao.append(Cromossomo(Util.gerar_palavra(len(estado_final)), estado_final))
    
    @staticmethod
    def exibir(populacao):        
        for i in populacao:
            print(i)

    @staticmethod
    def selecionar_por_torneio(populacao, nova_populacao, taxa_selecao):
        torneio = []
        qtd_selecionados = taxa_selecao * len(populacao) / 100
        qtd_selecionados = int(qtd_selecionados)

        cromossomo = populacao[0]        
        nova_populacao.append(cromossomo)  # elitismo
        
        i = 1
        while (i <= qtd_selecionados):
            c1 = populacao[random.randrange(len(populacao))]
            while True:
                c2 = populacao[random.randrange(len(populacao))]
                if c2 != c1:
                    break
            while True:
                c3 = populacao[random.randrange(len(populacao))]
                if c3 != c2 and c3 != c1:
                    break

            torneio.append(c1)
            torneio.append(c2)
            torneio.append(c3)
            torneio.sort()

            selecionado = torneio[0]
            if selecionado not in nova_populacao:
                nova_populacao.append(selecionado)
                i += 1

            torneio.clear()

    @staticmethod
    def reproduzir(populacao, nova_populacao, taxa_reproducao, estado_final):
        qtd_reproduzidos = taxa_reproducao * len(populacao) / 100
        qtd_reproduzidos = int(qtd_reproduzidos)
        
        i = 0
        while i < qtd_reproduzidos:
            pai = populacao[random.randrange(len(populacao))]
            while True:
                mae = populacao[random.randrange(len(populacao))]
                if mae != pai:
                    break

            sPai = pai.valor
            sMae = mae.valor

            sFilho1 = sPai[0: int(len(sPai)/2)] + sMae[int(len(sMae)/2):]
            sFilho2 = sMae[0: int(len(sMae)/2)] + sPai[int(len(sPai)/2):]

            nova_populacao.append(Cromossomo(sFilho1, estado_final))
            nova_populacao.append(Cromossomo(sFilho2, estado_final))
            i += 2

        while len(nova_populacao) > len(populacao):
            nova_populacao.pop()

    @staticmethod
    def mutar(populacao, estado_final):
        qtd_mutantes = random.randrange(int(len(populacao) / 5))
        
        while qtd_mutantes > 0:
            posicao_mutante = random.randrange(len(populacao))
            mutante = populacao[posicao_mutante]
            print("vai mutar", mutante)

            valor_mutado = mutante.valor
            caracter_mutante = mutante.valor[random.randrange(len(mutante.valor))]
            caracter_sorteado = Util.letras[random.randrange(Util.tamanho)]
            valor_mutado = valor_mutado.replace(caracter_mutante, caracter_sorteado)
            
            mutante = Cromossomo(valor_mutado, estado_final)
            populacao[posicao_mutante] = mutante
            qtd_mutantes -= 1
