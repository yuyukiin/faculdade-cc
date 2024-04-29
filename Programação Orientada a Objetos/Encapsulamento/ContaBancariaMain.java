package Exercícios;

import java.util.Scanner;

public class ContaBancariaMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe o saldo da conta:");
        double saldo = sc.nextDouble();
        
        System.out.println("Informe o limite da conta:");
        double limite = sc.nextDouble();
        
        ContaBancaria c = new ContaBancaria(saldo, limite);
        
        System.out.println("Saldo da conta: " + c.getSaldo());
        System.out.println("Limite da conta: " + c.getLimite());
        
        System.out.println("Informe o valor a ser sacado:");
        double valorSaque = sc.nextDouble();
        
        if(c.saque(valorSaque)) {
            System.out.println("Saque realizado com sucesso.");
            System.out.println("Novo saldo da conta: " + c.getSaldo());
        }
        
        sc.close();
    }
}
