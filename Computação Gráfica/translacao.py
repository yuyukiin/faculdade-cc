import numpy as np
import matplotlib.pyplot as plt

def translacao(pontos, Tx, Ty):
    pontos_transladados = []
    for ponto in pontos:
        x_u = ponto[0] + Tx
        y_u = ponto[1] + Ty
        pontos_transladados.append((x_u, y_u))
    return pontos_transladados

p1 = (6, 8)
p2 = (4, 5)
p3 = (8, 5)
array_pontos = [p1, p2, p3]

Tx = 3
Ty = -4

pontos_transladados = translacao(array_pontos, Tx, Ty)

lista_x_orig = [p1[0], p2[0], p3[0], p1[0]]
lista_y_orig = [p1[1], p2[1], p3[1], p1[1]]

lista_x_trans = [p[0] for p in pontos_transladados] + [pontos_transladados[0][0]]
lista_y_trans = [p[1] for p in pontos_transladados] + [pontos_transladados[0][1]]

plt.plot(lista_x_orig, lista_y_orig, 'bo-', label='Pontos originais')
plt.plot(lista_x_trans, lista_y_trans, 'ro-', label='Transladado (Triangulo)')

plt.xlim(-2, 15) 
plt.ylim(-2, 15) 
plt.xlabel('Eixo X')
plt.ylabel('Eixo Y')
plt.title('Translacao de Pontos no Plano Cartesiano')
plt.grid(True)
plt.legend()

plt.show()
