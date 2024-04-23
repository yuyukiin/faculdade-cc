package Exercícios;

public class Triangulo {
	private double ladoA, ladoB, ladoC;

	public Triangulo(double ladoA, double ladoB, double ladoC) {
		super();
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	public double getLadoA() {
		return ladoA;
	}

	public void setLadoA(double ladoA) {
		this.ladoA = ladoA;
	}

	public double getLadoB() {
		return ladoB;
	}

	public void setLadoB(double ladoB) {
		this.ladoB = ladoB;
	}

	public double getLadoC() {
		return ladoC;
	}

	public void setLadoC(double ladoC) {
		this.ladoC = ladoC;
	}
	
	public void verificaEquilatero() {
		if(this.ladoA == this.ladoB && this.ladoA == this.ladoC && this.ladoB == this.ladoC) {
			System.out.println("Triângulo é equilátero");
		}else {
			System.out.println("Triângulo não é equilátero");
		}
		return;
	}
	
}
