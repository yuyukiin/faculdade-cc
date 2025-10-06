import socket
import threading
import tkinter as tk
from tkinter import scrolledtext, simpledialog
from pessoa import Pessoa, serializa_pessoa

class Servidor:
    def __init__(self, master):
        self.master = master
        master.title("Servidor")

        self.lista_pessoas = []

        # Interface Gráfica
        self.lbl_porta = tk.Label(master, text="Porta")
        self.lbl_porta.pack()

        self.txt_porta = tk.Entry(master)
        self.txt_porta.pack()

        self.btn_iniciar = tk.Button(master, text="Iniciar", command=self.iniciar_servidor)
        self.btn_iniciar.pack()

        self.txa_logs = scrolledtext.ScrolledText(master, width=40, height=10)
        self.txa_logs.pack()

        self.jlist_clientes = tk.Listbox(master)
        self.jlist_clientes.pack()

    def log(self, msg):
        self.txa_logs.insert(tk.END, msg + "\n")

    def gerar_email(self, nome_pessoa):
        partes_nome = nome_pessoa.split(" ")
        return f"{partes_nome[0]}.{partes_nome[-1]}@ufn.edu.br".lower()

    def aguarda_clientes(self):
        while True:
            try:
                cliente_socket, endereco = self.servidor_socket.accept()
                self.log(f"Cliente conectado: {endereco[0]}:{endereco[1]}")
                
                thread_cliente = threading.Thread(target=self.handle_client, args=(cliente_socket,))
                thread_cliente.start()

            except Exception as e:
                self.log(f"Erro ao aguardar cliente: {e}")
                break

    def handle_client(self, cliente_socket):
        try:
            dados = cliente_socket.recv(1024)
            nome_pessoa = dados.decode('utf-8')

            email = self.gerar_email(nome_pessoa)
            nome_pessoa_upper = nome_pessoa.upper()

            p = Pessoa(nome_pessoa_upper, email)
            encontrado = any(pessoa.nome == p.nome for pessoa in self.lista_pessoas)

            if not encontrado:
                self.lista_pessoas.append(p)
                dados_serializados = serializa_pessoa(p)
                cliente_socket.send(dados_serializados)
                self.master.after(0, self.atualizar_lista_clientes)
            else:
                cliente_socket.send(b'null')

        except Exception as e:
            self.log(f"Erro no tratamento do cliente: {e}")
        finally:
            cliente_socket.close()

    def atualizar_lista_clientes(self):
        self.jlist_clientes.delete(0, tk.END)
        for pessoa in self.lista_pessoas:
            self.jlist_clientes.insert(tk.END, pessoa.nome)

    def iniciar_servidor(self):
        try:
            porta = int(self.txt_porta.get())
            self.servidor_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            self.servidor_socket.bind(("", porta))
            self.servidor_socket.listen(5)
            self.log(f"Servidor escutando na porta {porta}")
            
            self.btn_iniciar.config(state=tk.DISABLED)

            thread_servidor = threading.Thread(target=self.aguarda_clientes)
            thread_servidor.daemon = True
            thread_servidor.start()

        except Exception as e:
            self.log(f"Erro ao criar ServerSocket: {e}")

if __name__ == "__main__":
    root = tk.Tk()
    app = Servidor(root)
    root.mainloop()
