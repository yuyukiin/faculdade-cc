package exemplos;

public class exemplo1 {

	public static void main(String[] args) {
		// Exemplo 1: Tentando acessar um elemento fora do índice de um array
		try {
			int [] numeros = {1,2,3};
			System.out.println(numeros[3]); // ArrayIndexOutOfBoundsException
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro: índice fora do array"+e.getMessage());
		}
	}

}
