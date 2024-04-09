package exs;

import java.util.Scanner;

public class raizquadrada {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int n;
		try {
			System.out.println("Insira um numero para ser feita a raiz quadra: ");
			n = s.nextInt();
			System.out.println(Math.sqrt(n));
			System.out.println("Raiz quadrada: "+n);
		}catch(java.util.InputMismatchException e) {
			System.out.println("Erro: Não Número");
		}	
		
		
	}
}
