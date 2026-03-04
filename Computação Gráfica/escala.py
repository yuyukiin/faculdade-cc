import numpy as np
import matplotlib.pyplot as plt

def escala(pontos, Sx, Sy):
    pontos_escala = []
    for ponto in pontos:
        x_u = ponto[0] * Sx
        y_u = ponto[1] * Sy
        pontos_escala.append((x_u, y_u))
    return pontos_escala

p1 = (2, 2)
p2 = (4, 4)
array_pontos = [p1, p2]

Sx = 2
Sy = 2

pontos_escalados = escala(array_pontos, Sx, Sy)

lista_x_orig = [p1[0], p2[0]]
lista_y_orig = [p1[1], p2[1]]

lista_x_trans = [p[0] for p in pontos_escalados]
lista_y_trans = [p[1] for p in pontos_escalados]

plt.plot(lista_x_orig, lista_y_orig, 'bo-', label='Pontos originais')
plt.plot(lista_x_trans, lista_y_trans, 'ro-', label='Pontos escalados')

plt.xlim(0, 10) 
plt.ylim(0, 10) 
plt.xlabel('Eixo X')
plt.ylabel('Eixo Y')
plt.title('Escala de Pontos no Plano Cartesiano')
plt.grid(True)
plt.legend()

plt.show()
