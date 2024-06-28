class Grafo:
    def __init__(self, vertices):
        self.vertices = vertices
        self.qtd_vertices = len(vertices)
        self.qtd_arestas = 0
        self.matriz_adjacencia = [[0] * self.qtd_vertices for _ in range(self.qtd_vertices)]

    def inserir_aresta_simetrica(self, origem, destino):
        indice_origem = self.vertices.index(origem)
        indice_destino = self.vertices.index(destino)

        if origem.lower() == destino.lower() or indice_origem == -1 or indice_destino == -1:
            return

        if self.matriz_adjacencia[indice_origem][indice_destino] == 0:
            self.matriz_adjacencia[indice_origem][indice_destino] = 1
            self.qtd_arestas += 1

        if self.matriz_adjacencia[indice_destino][indice_origem] == 0:
            self.matriz_adjacencia[indice_destino][indice_origem] = 1
            self.qtd_arestas += 1

    def show(self):
        for i in range(self.qtd_vertices):
            print(f"{self.vertices[i]}\t\t\t", end="")
            for j in range(self.qtd_vertices):
                if self.matriz_adjacencia[i][j] != 0:
                    print(f"{self.vertices[j]}\t\t\t", end="")
            print()

    def mostrar_grau(self, cidade):
        indice = self.vertices.index(cidade)
        if indice == -1:
            return -1

        qtd = 0
        for i in range(self.qtd_vertices):
            if self.matriz_adjacencia[indice][i] != 0:
                qtd += 1
            if self.matriz_adjacencia[i][indice] != 0:
                qtd += 1
        return qtd
