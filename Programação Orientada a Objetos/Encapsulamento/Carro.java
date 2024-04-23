package Exercícios;

public class Carro {
	private String marca, modelo;
	private int ano;
	
	
	public Carro(String marca, String modelo, int ano) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void ExibirDetalhes() {
		System.out.println("Marca: " + this.marca + "\n Modelo: " + this.modelo + "\n Ano: " + this.ano);
		return; 
	}
}
