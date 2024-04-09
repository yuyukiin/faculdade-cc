package exs;
import java.util.Scanner;

public class stringparadouble {

	public static void main(String[] args) {
		String op;
		Scanner ler = new Scanner(System.in);
		String palavra;
		
		System.out.println("Insira uma mensagem que será convertida:");
		palavra = ler.nextLine();
		
		System.out.println("Insira se sera convertida para INT, DOUBLE OU FLOAT:");
		op = ler.nextLine().toUpperCase();
		
		try{
			switch(op) {
			case "INT":
				int valorInteiro = Integer.parseInt(palavra);
				System.out.println("Valor convertido INT: "+valorInteiro);
				break;
			case "FLOAT":
				float valorFloat = Float.parseFloat(palavra);
				System.out.println("Valor convertido FLOAT: "+valorFloat);
				break;
			case "DOUBLE":
				Double valorDouble = Double.parseDouble(palavra);
				System.out.println("Valor convertido DOUBLE: "+valorDouble);
				break;
			default:
				System.out.println("Digite um operador");
			}
		}catch(NumberFormatException e) {
			System.out.println("Erro: Não Possível converter");
		}	
	}
}
