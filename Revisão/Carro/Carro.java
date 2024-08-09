package Carro;

public class Carro {
    protected  String marca;

    public Carro(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void exibirMsg() {
        System.out.println("Carro da marca " + marca);
    }
}
