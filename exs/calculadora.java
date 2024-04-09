package exs;

import java.util.Scanner;

public class calculadora {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n, m;
		String op;
		
		try {
		System.out.println("Insira a operação: ");
		op = s.nextLine();	
		System.out.println("Insira o primeiro valor: ");
		n = s.nextInt();
		System.out.println("Insira o segundo valor: ");
		m = s.nextInt();
			
		switch(op) {
		case "+":
			System.out.println(n+m);
			break;
		case "-":
			System.out.println(n-m);
			break;
		case "/":
			System.out.println(n/m);
			break;
		case "x":
			System.out.println(n*m);
			break;
		default:
			System.out.println("Digite um operador");
		}
		
		}catch(java.util.InputMismatchException e) {
			System.out.println("Erro: Não utilizou números");
		}catch(Exception e) {
			System.out.println("Erro: zero");
		}
	}

}
