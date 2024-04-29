package Exercícios;

import java.util.Scanner;

public class TrianguloMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe o valor do lado A do triângulo:");
        double ladoA = sc.nextDouble();
        
        System.out.println("Informe o valor do lado B do triângulo:");
        double ladoB = sc.nextDouble();
        
        System.out.println("Informe o valor do lado C do triângulo:");
        double ladoC = sc.nextDouble();
        
        Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);
        
        System.out.println("Lado A do Triângulo: " + triangulo.getLadoA());
        System.out.println("Lado B do Triângulo: " + triangulo.getLadoB());
        System.out.println("Lado C do Triângulo: " + triangulo.getLadoC());
        
        if(triangulo.verificaEquilatero()) {
            System.out.println("O triângulo é equilátero.");
        } else {
            System.out.println("O triângulo não é equilátero.");
        }
        
        sc.close();
    }
}
