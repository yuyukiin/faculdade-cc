package Exercícios;

import java.util.Scanner;

public class CarroMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe a marca do carro:");
        String marca = sc.nextLine();
        
        System.out.println("Informe o modelo do carro:");
        String modelo = sc.nextLine();
        
        System.out.println("Informe o ano do carro:");
        int ano = sc.nextInt();
        
        Carro c = new Carro(marca, modelo, ano);
        
        System.out.println("Modelo do Carro: " + c.getModelo());
        System.out.println("Marca do Carro: " + c.getMarca());
        System.out.println("Ano do Carro: " + c.getAno());
        System.out.println("Detalhes do Carro: ");
        c.exibirDetalhes();
        
        sc.close();
    }
}
