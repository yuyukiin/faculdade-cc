package Exercícios;

import java.util.Scanner;

public class PessoaMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe o nome da pessoa:");
        String nome = sc.nextLine();
        
        System.out.println("Informe a idade da pessoa:");
        int idade = sc.nextInt();
        
        System.out.println("Informe o CPF da pessoa:");
        long cpf = sc.nextLong();
        
        Pessoa p = new Pessoa(nome, idade, cpf);
        
        System.out.println("Nome da Pessoa: " + p.getNome());
        System.out.println("Idade da Pessoa: " + p.getIdade());
        System.out.println("CPF da Pessoa: " + p.getCpf());
        
        if(p.verificaMaiorDeIdade()) {
            System.out.println("A pessoa é maior de idade.");
        } else {
            System.out.println("A pessoa não é maior de idade.");
        }
        
        sc.close();
    }
}
