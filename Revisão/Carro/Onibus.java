package Carro;

public class Onibus extends Carro {
    protected String modelo;

    public Onibus(String marca, String modelo) {
        super(marca);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
