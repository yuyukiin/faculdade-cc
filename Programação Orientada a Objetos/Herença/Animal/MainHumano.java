package Herença.Humano;

import java.util.Scanner;

public class MainHumano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Informe o tipo: ");
        String tipo = scanner.nextLine();

        Pessoa p = new Pessoa(nome, idade, tipo);

        System.out.println("\nDados da Pessoa:");
        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
        System.out.println("Tipo: " + p.getTipo());

        p.Andar();
        p.Falar();

        scanner.close();
    }
}