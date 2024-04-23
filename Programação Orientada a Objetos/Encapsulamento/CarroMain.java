package Exercícios;

public class CarroMain {

	public static void main(String[] args) {
		Carro c = new Carro("Uno", "Xs", 2001);
		
		System.out.println(c.getModelo());
		System.out.println(c.getMarca());
		System.out.println(c.getAno());
		System.out.println("Carro 1: ");
		//carro 1
		c.ExibirDetalhes();
		
		
		c.setModelo("Astra");
		c.setMarca("Monster");
		c.setAno(2000);
		//carro 2
		System.out.println("Carro 2: ");
		c.ExibirDetalhes();
		
	}

}
