import glfw
from OpenGL.GL import *
import OpenGL.GL.shaders
import numpy as np
import sys

Window = None
Shader_programm = None
Vao1 = None
Vao2 = None
WIDTH = 800
HEIGHT = 600

def redimensionaCallback(window, w, h):
    global WIDTH, HEIGHT
    WIDTH = w
    HEIGHT = h

def inicializaOpenGL():
    global Window, WIDTH, HEIGHT
    glfw.init()
    Window = glfw.create_window(WIDTH, HEIGHT, "Exercicio 4 - 2 VAOs e 4 VBOs", None, None)
    if not Window:
        glfw.terminate()
        sys.exit()
    glfw.set_window_size_callback(Window, redimensionaCallback)
    glfw.make_context_current(Window)

def inicializaObjetos():
    global Vao1, Vao2
    
    # ---------------- TRIÂNGULO 1 ----------------
    Vao1 = glGenVertexArrays(1)
    glBindVertexArray(Vao1)

    points1 = [-0.5,  0.5, 0.0, -0.1, -0.5, 0.0, -0.9, -0.5, 0.0]
    points1 = np.array(points1, dtype=np.float32)
    pvbo1 = glGenBuffers(1) # VBO 1 (Pontos T1) [cite: 696, 697]
    glBindBuffer(GL_ARRAY_BUFFER, pvbo1)
    glBufferData(GL_ARRAY_BUFFER, points1, GL_STATIC_DRAW)
    glEnableVertexAttribArray(0)
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, None)

    cores1 = [1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0]
    cores1 = np.array(cores1, dtype=np.float32)
    cvbo1 = glGenBuffers(1) # VBO 2 (Cores T1) [cite: 696, 697]
    glBindBuffer(GL_ARRAY_BUFFER, cvbo1)
    glBufferData(GL_ARRAY_BUFFER, cores1, GL_STATIC_DRAW)
    glEnableVertexAttribArray(1)
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 0, None)

    # ---------------- TRIÂNGULO 2 ----------------
    Vao2 = glGenVertexArrays(1)
    glBindVertexArray(Vao2)

    points2 = [0.5,  0.5, 0.0, 0.9, -0.5, 0.0, 0.1, -0.5, 0.0]
    points2 = np.array(points2, dtype=np.float32)
    pvbo2 = glGenBuffers(1) # VBO 3 (Pontos T2) [cite: 696, 697]
    glBindBuffer(GL_ARRAY_BUFFER, pvbo2)
    glBufferData(GL_ARRAY_BUFFER, points2, GL_STATIC_DRAW)
    glEnableVertexAttribArray(0)
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, None)

    cores2 = [1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0]
    cores2 = np.array(cores2, dtype=np.float32)
    cvbo2 = glGenBuffers(1) # VBO 4 (Cores T2) [cite: 696, 697]
    glBindBuffer(GL_ARRAY_BUFFER, cvbo2)
    glBufferData(GL_ARRAY_BUFFER, cores2, GL_STATIC_DRAW)
    glEnableVertexAttribArray(1)
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 0, None)

def inicializaShaders():
    global Shader_programm
    vertex_shader = """
    #version 400
    layout(location = 0) in vec3 vertex_posicao;
    layout(location = 1) in vec3 vertex_cores;
    out vec3 cores;
    void main () {
        cores = vertex_cores;
        gl_Position = vec4 (vertex_posicao.x, vertex_posicao.y, vertex_posicao.z, 1.0);
    }
    """
    vs = OpenGL.GL.shaders.compileShader(vertex_shader, GL_VERTEX_SHADER)
    fragment_shader = """
    #version 400
    in vec3 cores;
    out vec4 frag_colour;
    void main () {
        frag_colour = vec4 (cores.r, cores.g, cores.b, 1.0);
    }
    """
    fs = OpenGL.GL.shaders.compileShader(fragment_shader, GL_FRAGMENT_SHADER)
    Shader_programm = OpenGL.GL.shaders.compileProgram(vs, fs)
    glDeleteShader(vs)
    glDeleteShader(fs)

def inicializaRenderizacao():
    global Window, Shader_programm, Vao1, Vao2, WIDTH, HEIGHT
    while not glfw.window_should_close(Window):
        glClear(GL_COLOR_BUFFER_BIT)
        glClearColor(0.2, 0.3, 0.3, 1.0)
        glViewport(0, 0, WIDTH, HEIGHT)
        glUseProgram(Shader_programm)
        
        # Desenha Triângulo 1
        glBindVertexArray(Vao1)
        glDrawArrays(GL_TRIANGLES, 0, 3) 
        
        # Desenha Triângulo 2
        glBindVertexArray(Vao2)
        glDrawArrays(GL_TRIANGLES, 0, 3) 
        
        glfw.poll_events()
        glfw.swap_buffers(Window)
        if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_ESCAPE)):
            glfw.set_window_should_close(Window, True)
    glfw.terminate()

def main():
    inicializaOpenGL()
    inicializaObjetos()
    inicializaShaders()
    inicializaRenderizacao()

if __name__ == "__main__":
    main()