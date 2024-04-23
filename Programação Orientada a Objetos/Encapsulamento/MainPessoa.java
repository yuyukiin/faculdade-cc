package Exemplos;

public class MainPessoa {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa ("Yuri", 22);
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getIdade());
		
		pessoa.setNome("Yuroooo");
		pessoa.setIdade(25);
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getIdade());
		
		
		
	}

}
