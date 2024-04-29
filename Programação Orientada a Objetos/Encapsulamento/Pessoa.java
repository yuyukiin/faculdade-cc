package Exercícios;

import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private long cpf;

    public Pessoa(String nome, int idade, long cpf) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public boolean verificaMaiorDeIdade() {
        return idade >= 18;
    }
}
