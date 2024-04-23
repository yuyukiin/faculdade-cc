package Exercícios;

import java.util.Scanner;

public class ContaBancariaMian {

	public static void main(String[] args) {
		ContaBancaria c = new ContaBancaria(100, 2000);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o saldo: ");
		c.getSaldo();
		
		System.out.println("Insira o limite: ");
		c.getSaldo();
		
		System.out.println(c.getSaldo());
		System.out.println(c.getLimite());
		
		
	}

}
