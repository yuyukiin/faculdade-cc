package Pessoa;

public class MainPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 25);
        meuMetodo(pessoa);
    }
    
    public static void meuMetodo(Pessoa p) {
        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
    }
}

