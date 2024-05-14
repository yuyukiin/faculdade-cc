package Herença.PessoaTrabalho;

import Herença.Desenho.Quadrado;

public class MainPessoa {
    public static void main(String[] args) {
        Funcionario q = new Funcionario("Yuri");
        q.setNome(null);
        System.out.println("Nome: " + q.getNome());
        q.Trabalhar();
        q.Trabalho();

    }
}

