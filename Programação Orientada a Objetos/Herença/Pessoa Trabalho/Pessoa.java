package Herença.PessoaTrabalho;

public class Pessoa {
    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void Trabalho(){
        System.out.println("Estou trabalhando!");
    }
}
