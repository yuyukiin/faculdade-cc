package exemplos;

public class exemplo2 {

	public static void main(String[] args) {
		// Exemplo 2: Divisão por zero
		try {
			int a = 10;
			int b = 0;
			System.out.println(a/b); // ArithmeticException
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}

}
