from vpython import *
#Web VPython 3.2

esquerda = box(pos=vector(-10,0,0), length=1, height=1, width=1, color=color.green)
direita = box(pos=vector(10,0,0), length=1, height=1, width=1, color=color.red)

esfera = sphere(pos=vector(0,0,0), radius=1, color=color.purple)

dir = 1

while True:
    rate(5)
    esfera.pos.x += dir
    
    if esfera.pos.x >= direita.pos.x - 1:
        direita.visible = False  
        esfera.pos.x = esquerda.pos.x + 1  
        dir = 0  
    
    elif esfera.pos.x <= esquerda.pos.x + 1:
        esquerda.visible = False  
        esfera.pos.x = direita.pos.x - 1 
        dir = 0  
