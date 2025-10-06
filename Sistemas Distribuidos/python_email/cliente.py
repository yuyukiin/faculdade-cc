import socket
import tkinter as tk
from tkinter import scrolledtext, messagebox
from pessoa import Pessoa, deserializa_pessoa

class Cliente:
    def __init__(self, master):
        self.master = master
        master.title("Cliente")

        self.lbl_nome = tk.Label(master, text="Nome")
        self.lbl_nome.pack()

        self.txt_nome = tk.Entry(master, width=50)
        self.txt_nome.pack()

        self.lbl_porta = tk.Label(master, text="Porta")
        self.lbl_porta.pack()

        self.txt_porta = tk.Entry(master)
        self.txt_porta.pack()

        self.btn_conectar = tk.Button(master, text="Conectar", command=self.conectar)
        self.btn_conectar.pack()

        self.txa_logs = scrolledtext.ScrolledText(master, width=40, height=10)
        self.txa_logs.pack()

    def log(self, msg):
        self.txa_logs.insert(tk.END, msg + "\n")

    def conectar(self):
        nome = self.txt_nome.get()
        if not nome:
            messagebox.showerror("Erro", "Digite seu nome completo.")
            return

        try:
            porta = int(self.txt_porta.get())
        except ValueError:
            messagebox.showerror("Erro", "Porta inválida.")
            return

        try:
            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                s.connect(("localhost", porta))
                self.log(f"Conectado ao servidor na porta {porta}")

                s.sendall(nome.encode('utf-8'))

                dados = s.recv(1024)
                if dados == b'null':
                    messagebox.showinfo("Info", "Seu nome já está na lista com um e-mail gerado.")
                    self.log("Pessoa já cadastrada.")
                else:
                    pessoa = deserializa_pessoa(dados)
                    self.log(f"Pessoa criada: {pessoa.nome} - {pessoa.email}")

        except Exception as ex:
            messagebox.showerror("Erro", f"Erro ao conectar: {ex}")
            self.log(f"Erro: {ex}")

if __name__ == "__main__":
    root = tk.Tk()
    app = Cliente(root)
    root.mainloop()
