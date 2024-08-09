package Animal;

public class Animal {
    protected String nome, som;
    protected int idade;
    
    public Animal(String nome, String som, int idade) {
        this.nome = nome;
        this.som = som;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSom() {
        return som;
    }

    public void setSom(String som) {
        this.som = som;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    
}
