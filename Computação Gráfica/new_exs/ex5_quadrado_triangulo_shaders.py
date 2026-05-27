import glfw
from OpenGL.GL import *
import OpenGL.GL.shaders
import numpy as np
import sys

Window = None
Shader_programm_quadrado = None
Shader_programm_triangulo = None
Vao_quadrado = None
Vao_triangulo = None
WIDTH = 800
HEIGHT = 600

def redimensionaCallback(window, w, h):
    global WIDTH, HEIGHT
    WIDTH = w
    HEIGHT = h

def inicializaOpenGL():
    global Window, WIDTH, HEIGHT
    glfw.init()
    Window = glfw.create_window(WIDTH, HEIGHT, "Exercicio 5 - Quadrado e Triangulo", None, None)
    if not Window:
        glfw.terminate()
        sys.exit()
    glfw.set_window_size_callback(Window, redimensionaCallback)
    glfw.make_context_current(Window)

def inicializaQuadrado():
    global Vao_quadrado
    Vao_quadrado = glGenVertexArrays(1)
    glBindVertexArray(Vao_quadrado)

    # 6 vértices compõem 1 quadrado desenhado com GL_TRIANGLES
    points = [
        -0.9,  0.5, 0.0, 
        -0.9, -0.5, 0.0, 
        -0.1, -0.5, 0.0, 
        -0.9,  0.5, 0.0, 
        -0.1, -0.5, 0.0, 
        -0.1,  0.5, 0.0  
    ]
    points = np.array(points, dtype=np.float32)
    pvbo = glGenBuffers(1)
    glBindBuffer(GL_ARRAY_BUFFER, pvbo)
    glBufferData(GL_ARRAY_BUFFER, points, GL_STATIC_DRAW)
    glEnableVertexAttribArray(0)
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, None)

    cores = [
        1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0,
        1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0
    ]
    cores = np.array(cores, dtype=np.float32)
    cvbo = glGenBuffers(1)
    glBindBuffer(GL_ARRAY_BUFFER, cvbo)
    glBufferData(GL_ARRAY_BUFFER, cores, GL_STATIC_DRAW)
    glEnableVertexAttribArray(1)
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 0, None)

def inicializaTriangulo():
    global Vao_triangulo
    Vao_triangulo = glGenVertexArrays(1)
    glBindVertexArray(Vao_triangulo)

    points = [
         0.5,  0.5, 0.0, 
         0.9, -0.5, 0.0, 
         0.1, -0.5, 0.0  
    ]
    points = np.array(points, dtype=np.float32)
    pvbo = glGenBuffers(1)
    glBindBuffer(GL_ARRAY_BUFFER, pvbo)
    glBufferData(GL_ARRAY_BUFFER, points, GL_STATIC_DRAW)
    glEnableVertexAttribArray(0)
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, None)

    cores = [0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0]
    cores = np.array(cores, dtype=np.float32)
    cvbo = glGenBuffers(1)
    glBindBuffer(GL_ARRAY_BUFFER, cvbo)
    glBufferData(GL_ARRAY_BUFFER, cores, GL_STATIC_DRAW)
    glEnableVertexAttribArray(1)
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 0, None)

def inicializaShaderQuadrado():
    global Shader_programm_quadrado
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
    Shader_programm_quadrado = OpenGL.GL.shaders.compileProgram(vs, fs)
    glDeleteShader(vs)
    glDeleteShader(fs)

def inicializaShaderTriangulo():
    global Shader_programm_triangulo
    # Shader igual para fins didáticos, mas compilado separadamente
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
    Shader_programm_triangulo = OpenGL.GL.shaders.compileProgram(vs, fs)
    glDeleteShader(vs)
    glDeleteShader(fs)

def inicializaRenderizacao():
    global Window, Shader_programm_quadrado, Shader_programm_triangulo, Vao_quadrado, Vao_triangulo, WIDTH, HEIGHT
    while not glfw.window_should_close(Window):
        glClear(GL_COLOR_BUFFER_BIT)
        glClearColor(0.2, 0.3, 0.3, 1.0)
        glViewport(0, 0, WIDTH, HEIGHT)
        
        # desenha o quadrado [cite: 702]
        glUseProgram(Shader_programm_quadrado) # ativa o shader do quadrado [cite: 703]
        glBindVertexArray(Vao_quadrado) # ativa o VAO do quadrado [cite: 703]
        glDrawArrays(GL_TRIANGLES, 0, 6) # renderiza o quadrado [cite: 704]
        
        # desenha o triângulo [cite: 705]
        glUseProgram(Shader_programm_triangulo) # troca de shader, ativando o shader do triangulo [cite: 706]
        glBindVertexArray(Vao_triangulo) # troca de VAO, ativando o VAO do triângulo [cite: 706]
        glDrawArrays(GL_TRIANGLES, 0, 3) # renderiza o triângulo [cite: 707]
        
        glfw.poll_events()
        glfw.swap_buffers(Window)
        if (glfw.PRESS == glfw.get_key(Window, glfw.KEY_ESCAPE)):
            glfw.set_window_should_close(Window, True)
    glfw.terminate()

# Função principal [cite: 708]
def main(): # [cite: 709]
    inicializaOpenGL() # [cite: 710]
    inicializaQuadrado() # [cite: 711]
    inicializaTriangulo() # [cite: 711]
    inicializaShaderQuadrado() # [cite: 712]
    inicializaShaderTriangulo() # [cite: 712]
    inicializaRenderizacao() # [cite: 713]

if __name__ == "__main__": # [cite: 715]
    main() # [cite: 715]