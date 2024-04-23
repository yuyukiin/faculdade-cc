package Exercícios;

public class PessoaMain {

	public static void main(String[] args) {
		Pessoa p = new Pessoa ("Yuri", 21, 020);
		
		System.out.println("Yuri: ");
		System.out.println(p.getNome());
		System.out.println(p.getIdade());
		System.out.println(p.getCpf());
		p.verificaMaiorDeldade();
	
		System.out.println("Gilberto: ");
		p.setNome("Gigi");
		p.setIdade(19);
		p.setCpf(020);
		p.verificaMaiorDeldade();	

	}

}
