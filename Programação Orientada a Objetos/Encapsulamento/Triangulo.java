package Exercícios;

import java.util.Scanner;

public class Triangulo {
    private double ladoA, ladoB, ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        super();
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }
    
    public boolean verificaEquilatero() {
        return ladoA == ladoB && ladoA == ladoC && ladoB == ladoC;
    }
}
