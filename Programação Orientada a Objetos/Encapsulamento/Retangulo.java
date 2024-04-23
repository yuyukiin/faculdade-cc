package Exercícios;

public class Retangulo {
	private double altura;
	private double base;
	
	public Retangulo(double altura, double base) {
		super();
		this.altura = altura;
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}
	
	public double CalcularArea() {
		return (base*altura);
	}
	
}
