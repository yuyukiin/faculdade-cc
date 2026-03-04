import numpy as np
import matplotlib.pyplot as plt

def rotacao(pontos, angulo):
    pontos_rotacionados = []
    angulo_rad = np.radians(angulo)
    for ponto in pontos:
        x0 = ponto[0]
        y0 = ponto[1]
        xu = round(x0 * np.cos(angulo_rad) - y0 * np.sin(angulo_rad), 2)
        yu = round(x0 * np.sin(angulo_rad) + y0 * np.cos(angulo_rad), 2)
        pontos_rotacionados.append((xu, yu))
    return pontos_rotacionados

p1 = (2, 2)
p2 = (4, 4)
array_pontos = [p1, p2]

angulo = 45

pontos_rot = rotacao(array_pontos, angulo)

lista_x_orig = [p1[0], p2[0]]
lista_y_orig = [p1[1], p2[1]]

lista_x_rot = [p[0] for p in pontos_rot]
lista_y_rot = [p[1] for p in pontos_rot]

plt.plot(lista_x_orig, lista_y_orig, 'bo-', label='Pontos originais')
plt.plot(lista_x_rot, lista_y_rot, 'ro-', label='Pontos rotacionados')

plt.xlim(-2, 6) 
plt.ylim(-2, 8) 
plt.xlabel('Eixo X')
plt.ylabel('Eixo Y')
plt.title('Rotacao de Pontos no Plano Cartesiano')
plt.grid(True)
plt.legend()

plt.show()
