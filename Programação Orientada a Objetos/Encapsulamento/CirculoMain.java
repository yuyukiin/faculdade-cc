package Exercícios;
import java.util.Scanner;

public class CirculoMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe o raio do círculo:");
        double raio = sc.nextDouble();
        
        Circulo c = new Circulo(raio);
        
        System.out.println("Raio do Círculo: " + c.getRaio());
        
        System.out.println("Área do Círculo: " + c.calculaArea());
        
        sc.close();
    }
}
