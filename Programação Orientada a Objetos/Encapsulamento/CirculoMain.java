package Exercícios;

public class CirculoMain {

	public static void main(String[] args) {
		Circulo c = new Circulo(2);
		
		System.out.println(c.getRaio());
		c.setRaio(6);
		
		System.out.println("Área do Circulo: " + c.calculeArea());

	}

}
