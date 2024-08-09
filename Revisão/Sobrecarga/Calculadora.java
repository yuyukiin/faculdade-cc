package Sobrecarga;

public class Calculadora {

    public void somar(int a, int b) {
        double resultado;
        resultado = a + b;
        System.out.println("Resultado: " + resultado);
    }

    public void somar(int a, int b, int c) {
        double resultado;
        resultado = a + b + c;
        System.out.println("Resultado: " + resultado);
    }

    public void media(double a, double b) {
        double resultado;
        resultado = (a + b) / 2;
        System.out.println("Resultado: " + resultado);
    }

    public void media(double a, double b, double c) {
        double resultado;
        resultado = (a + b + c) / 3;
        System.out.println("Resultado: " + resultado);
    }
}
