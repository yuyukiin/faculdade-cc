from vpython import *
#Web VPython 3.2

from vpython import sphere, vector, rate, sqrt, pow

def calc_y(pos_x, r):
    return sqrt(r**2 - (pos_x - 10)**2) + 10

# Objetos
earth = sphere(pos=vector(10, 10, 0), radius=5, color=vector(0, 0, 1))
moon1 = sphere(pos=vector(10, 0, 10), radius=1, color=vector(0.5, 0, 0.5), make_trail=True)
moon2 = sphere(pos=vector(30, 0, 0), radius=1, color=vector(0, 0.5, 0), make_trail=True)

dir1 = 1
x1 = 0

dir2 = 1
x2 = 0

while True:
    rate(40)
    earth.pos.z += 0.1
    
    if dir1 < 0:
        y1 = 20 - calc_y(x1, 10)
        print("y1:", y1)
    else:
        y1 = calc_y(x1, 10)
        print("y1:", y1)
    
    moon1.pos.x = x1
    moon1.pos.y = y1
    moon1.pos.z += 0.1
    
    moon2.pos.x = x2
    moon2.pos.y = y1
    moon2.pos.z += 0.1
    
    x1 += dir1
    if x1 == 20:
        dir1 = -1
    if x1 == 0:
        dir1 = 1
    
    x2 += dir2
    if x2 == 20:
        dir2 = -1
    if x2 == 0:
        dir2 = 1
