package Exercícios;

import java.util.Scanner;

public class RetanguloMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe a altura do retângulo:");
        double altura = sc.nextDouble();
        
        System.out.println("Informe a base do retângulo:");
        double base = sc.nextDouble();
        
        RetanguloNew retangulo = new RetanguloNew(altura, base);
        
        System.out.println("Altura do Retângulo: " + retangulo.getAltura());
        System.out.println("Base do Retângulo: " + retangulo.getBase());
        
        System.out.println("Área do Retângulo: " + retangulo.calcularArea());
        
        sc.close();
    }
}
