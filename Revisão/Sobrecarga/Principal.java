package Sobrecarga;

public class Principal {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        c.somar(10, 20);
        c.somar(10, 20, 30);
        c.media(10, 20);
        c.media(10, 20, 30);
    }
}
