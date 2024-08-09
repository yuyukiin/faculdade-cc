package Pessoa;

public class Principal {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("João", 20);
        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
        p.setNome("Osvaldo");
        p.setIdade(55);
        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
    }
}