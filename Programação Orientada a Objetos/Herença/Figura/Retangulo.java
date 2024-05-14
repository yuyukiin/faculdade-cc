package Herença.Figura;

public class Retangulo extends figura {
    protected int largura;
    protected int altura;
    
    public int getLargura() {
        return largura;
    }
    public void setLargura(int largura) {
        this.largura = largura;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void calcularArea(int altura, int largura){
        System.out.println("A área do retângulo é: " + (altura * largura));
    }

}
