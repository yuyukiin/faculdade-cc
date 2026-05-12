import pygame
from pygame.locals import *
from OpenGL.GL import *
from OpenGL.GLU import *

def carrega_textura(caminho_imagem):
    textura_surface = pygame.image.load(caminho_imagem)
    textura_dados = pygame.image.tostring(textura_surface, "RGB", 1)
    largura = textura_surface.get_width()
    altura = textura_surface.get_height()

    tex_id = glGenTextures(1)
    glBindTexture(GL_TEXTURE_2D, tex_id)
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR)
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR)
    glTexImage2D(GL_TEXTURE_2D, 0, 3, largura, altura, 0, GL_RGB, GL_UNSIGNED_BYTE, textura_dados)
    return tex_id

def desenha_cubo():
    glBegin(GL_QUADS)
    glNormal3f(0.0, 0.0, 1.0)
    glTexCoord2f(0.0, 0.0); glVertex3f(-1.0, -1.0,  1.0)
    glTexCoord2f(1.0, 0.0); glVertex3f( 1.0, -1.0,  1.0)
    glTexCoord2f(1.0, 1.0); glVertex3f( 1.0,  1.0,  1.0)
    glTexCoord2f(0.0, 1.0); glVertex3f(-1.0,  1.0,  1.0)
    glNormal3f(0.0, 0.0, -1.0)
    glTexCoord2f(1.0, 0.0); glVertex3f(-1.0, -1.0, -1.0)
    glTexCoord2f(1.0, 1.0); glVertex3f(-1.0,  1.0, -1.0)
    glTexCoord2f(0.0, 1.0); glVertex3f( 1.0,  1.0, -1.0)
    glTexCoord2f(0.0, 0.0); glVertex3f( 1.0, -1.0, -1.0)
    glNormal3f(0.0, 1.0, 0.0)
    glTexCoord2f(0.0, 1.0); glVertex3f(-1.0,  1.0, -1.0)
    glTexCoord2f(0.0, 0.0); glVertex3f(-1.0,  1.0,  1.0)
    glTexCoord2f(1.0, 0.0); glVertex3f( 1.0,  1.0,  1.0)
    glTexCoord2f(1.0, 1.0); glVertex3f( 1.0,  1.0, -1.0)
    glNormal3f(0.0, -1.0, 0.0)
    glTexCoord2f(1.0, 1.0); glVertex3f(-1.0, -1.0, -1.0)
    glTexCoord2f(0.0, 1.0); glVertex3f( 1.0, -1.0, -1.0)
    glTexCoord2f(0.0, 0.0); glVertex3f( 1.0, -1.0,  1.0)
    glTexCoord2f(1.0, 0.0); glVertex3f(-1.0, -1.0,  1.0)
    glNormal3f(1.0, 0.0, 0.0)
    glTexCoord2f(1.0, 0.0); glVertex3f( 1.0, -1.0, -1.0)
    glTexCoord2f(1.0, 1.0); glVertex3f( 1.0,  1.0, -1.0)
    glTexCoord2f(0.0, 1.0); glVertex3f( 1.0,  1.0,  1.0)
    glTexCoord2f(0.0, 0.0); glVertex3f( 1.0, -1.0,  1.0)
    glNormal3f(-1.0, 0.0, 0.0)
    glTexCoord2f(0.0, 0.0); glVertex3f(-1.0, -1.0, -1.0)
    glTexCoord2f(1.0, 0.0); glVertex3f(-1.0, -1.0,  1.0)
    glTexCoord2f(1.0, 1.0); glVertex3f(-1.0,  1.0,  1.0)
    glTexCoord2f(0.0, 1.0); glVertex3f(-1.0,  1.0, -1.0)
    glEnd()

def desenha_chao(tex_id):
    glBindTexture(GL_TEXTURE_2D, tex_id)
    glBegin(GL_QUADS)
    glNormal3f(0.0, 1.0, 0.0)
    glTexCoord2f(0.0, 0.0); glVertex3f(-15.0, -2.0, -15.0)
    glTexCoord2f(10.0, 0.0); glVertex3f(-15.0, -2.0,  15.0)
    glTexCoord2f(10.0, 10.0); glVertex3f( 15.0, -2.0,  15.0)
    glTexCoord2f(0.0, 10.0); glVertex3f( 15.0, -2.0, -15.0)
    glEnd()

def desenha_parede(tex_id):
    glBindTexture(GL_TEXTURE_2D, tex_id)
    glBegin(GL_QUADS)
    glNormal3f(0.0, 0.0, 1.0)
    glTexCoord2f(0.0, 0.0); glVertex3f(-10.0, -2.0, -5.0)
    glTexCoord2f(5.0, 0.0); glVertex3f( 10.0, -2.0, -5.0)
    glTexCoord2f(5.0, 5.0); glVertex3f( 10.0,  8.0, -5.0)
    glTexCoord2f(0.0, 5.0); glVertex3f(-10.0,  8.0, -5.0)
    glEnd()

def main():
    pygame.init()
    display = (800, 600)
    pygame.display.set_mode(display, DOUBLEBUF | OPENGL)
    
    glEnable(GL_DEPTH_TEST)
    glEnable(GL_TEXTURE_2D)
    glEnable(GL_LIGHTING)
    glEnable(GL_LIGHT0)
    glEnable(GL_COLOR_MATERIAL)

    glLightModelfv(GL_LIGHT_MODEL_AMBIENT, [0.1, 0.2, 0.5, 1.0]) 
    glLightfv(GL_LIGHT0, GL_POSITION, [5.0, 5.0, 2.0, 1.0])
    glLightfv(GL_LIGHT0, GL_DIFFUSE, [0.8, 0.8, 0.8, 1.0])

    gluPerspective(45, (display[0]/display[1]), 0.1, 50.0)
    glTranslatef(0.0, 0.0, -15.0)

    tex_caixa = carrega_textura("texturas/caixa.jpg")
    tex_madeira = carrega_textura("texturas/madeira.jpg")
    tex_grama = carrega_textura("texturas/grama.jpg")
    tex_parede = carrega_textura("texturas/parede.jpg")

    rodando = True
    while rodando:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                rodando = False

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
        glPushMatrix()

        mouse_x, mouse_y = pygame.mouse.get_pos()
        glRotatef(mouse_x * 0.1, 0, 1, 0)
        glRotatef(mouse_y * 0.1, 1, 0, 0)

        desenha_chao(tex_grama)
        desenha_parede(tex_parede)

        glBindTexture(GL_TEXTURE_2D, tex_caixa)
        glPushMatrix()
        glTranslatef(-3.0, -1.0, 0.0)
        desenha_cubo()
        glPopMatrix()

        glBindTexture(GL_TEXTURE_2D, tex_madeira)
        glPushMatrix()
        glTranslatef(1.0, -1.0, 0.0)
        desenha_cubo()
        glPopMatrix()

        texturas_totem = [tex_parede, tex_caixa, tex_madeira]
        for i in range(3):
            glBindTexture(GL_TEXTURE_2D, texturas_totem[i])
            glPushMatrix()
            glTranslatef(5.0, -1.0 + (i * 2.0), -2.0) 
            desenha_cubo()
            glPopMatrix()

        glPopMatrix()
        pygame.display.flip()
        pygame.time.wait(10)

if __name__ == "__main__":
    main()
