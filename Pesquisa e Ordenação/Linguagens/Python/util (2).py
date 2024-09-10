import random

class Util:

    @staticmethod
    def gerar_palavras(tamanho):
        """função gerar_palavras gera uma palavra aleatória de acordo com o tamanho informado

        Args:
            tamanho (_type_): quantidade de letras que a palavra terá

        Returns:
            _type_: palavra gerada
        """

        letras = "abcdefghijklmnopqrstuvwxyz"
        palavra = ""
        for i in range(tamanho):
            palavra += Util.letras[Util.gerador.randint(
                0, len(Util.letras) - 1)]
        return palavra

    @staticmethod
    def gerar_palavras_lista(palavras, quantidade, tamanho):
        """função gerar_palavras_lista gera uma lista de palavras aleatórias

        Args:
            palavras (_type_): lista que receberá as palavras
            quantidade (_type_): quantidade de palavras a serem geradas
            tamanho (_type_): quantidade de letras que cada palavra terá
        """
        for i in range(quantidade):
            palavras.append(Util.gerar_palavras(tamanho))

    @staticmethod
    def exibir(lista, frase):
        """função exibir exibe uma lista de palavras

        Args:
            lista (_type_): lista de palavras a ser exibida
            frase (_type_): frase que será exibida antes da lista
        """
        print(frase)
        for palavra in lista:
            print(palavra)