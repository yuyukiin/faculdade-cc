package Herença.Humano;

public class Pessoa extends SerHumano {
    public Pessoa(String nome, int idade, String tipo) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", tipo=" + tipo + "]";
    }
}