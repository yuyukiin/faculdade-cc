package exs;

//Tentativa de acesso a um índice inválido quando é feita em um array. 
//O índice pode ser menor que zero ou maior ou igual ao comprimento do array.

public class excecoestwo {

	public class Main {
	    public static void main(String[] args) {
	        int[] arr = {1, 2, 3};
	        try {
	            System.out.println(arr[3]); // Isso causará ArrayIndexOutOfBoundsException
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("Índice fora do intervalo do array.");
	        }
	    }
	}
}