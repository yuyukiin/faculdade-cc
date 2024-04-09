package exemplos;

public class exemplo3 {

	public static void main(String[] args) {
		// Exemplo 3: Tentando converter uma String em um número
		try {
			String numero = "abc";
			int valor = Integer.parseInt(numero); // NumberFormatException
		}catch(NumberFormatException e) {
			System.out.println("Erro: índice fora do array"+e.getMessage());
		}
	}

}
