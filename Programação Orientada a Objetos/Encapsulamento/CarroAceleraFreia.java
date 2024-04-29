package Exercícios;

public class CarroAceleraFreia {
    private String placa;
    private int velocidade;

    public CarroAceleraFreia(String placa) {
        this.placa = placa;
        this.velocidade = 0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void acelerar(int valor) {
        this.velocidade += valor;
    }

    public void freiar(int valor) {
        if (this.velocidade - valor >= 0) {
            this.velocidade -= valor;
        } else {
            this.velocidade = 0;
        }
    }
}
