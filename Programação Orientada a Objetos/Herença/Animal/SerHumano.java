package Herença.Humano;

public class SerHumano extends Animal {
    protected String nome; 
    protected int idade;

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

    public void Falar(){
        System.out.println("Nem todos falam!");
    }
}
