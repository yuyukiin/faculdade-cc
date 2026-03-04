import numpy as np
import matplotlib.pyplot as plt

"""
Agora complete o algoritmo anterior para o exemplo do Slide 8, que tem 3
pontos, ao invés de 2 apenas.
p1(6,8)
p2(4,5)
p3(8,5)
(tx, ty) = (3,-4)
p1'(?,?) = (9,4)
p2'(?,?) = (7,1)
p3'(?,?) = (11,1)


"""

# Função para calcular a translação dos pontos
def translacao(pontos, Tx, Ty):
    pontos_transladados = []
    for ponto in pontos:
        x_u = ponto[0] + Tx
        y_u = ponto[1] + Ty
        pontos_transladados.append((x_u, y_u))
    return pontos_transladados

# --- Preparação dos Dados ---

# Pontos originais (definidos como tuplas)
p1 = (6, 8)
p2 = (4, 5)
p3 = (8,5)
array_pontos = [p1, p2, p3]

# Vetor de translação
Tx = 3
Ty = -4

pontos_transladados = translacao(array_pontos, Tx, Ty)

lista_x_orig = [p1[0], p2[0], p3[0], p1[0]]
lista_y_orig = [p1[1], p2[1], p3[1], p1[1]]

lista_x_trans = [p[0] for p in pontos_transladados] + [pontos_transladados[0][0]]
lista_y_trans = [p[1] for p in pontos_transladados] + [pontos_transladados[0][1]]

# --- Plotagem do Gráfico ---

# Plotar os pontos originais
plt.plot(lista_x_orig, lista_y_orig, 'bo-', label='Pontos originais')
plt.plot(lista_x_trans, lista_y_trans, 'ro-', label='Transladado (Triângulo)')

# Organizar as coordenadas transladadas para o plot
lista_x = [pontos_transladados[0][0], pontos_transladados[1][0]]
lista_y = [pontos_transladados[0][1], pontos_transladados[1][1]]

# Plotar os pontos transladados
plt.plot(lista_x, lista_y, 'ro-', label='Pontos transladados')

# Configurações de exibição
plt.xlim(-2, 20) 
plt.ylim(-2, 20) 
plt.xlabel('Eixo X')
plt.ylabel('Eixo Y')
plt.title('Translação de Pontos no Plano Cartesiano')
plt.grid(True)
plt.legend()

# Mostrar o gráfico
plt.show()