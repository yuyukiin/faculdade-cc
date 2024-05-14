package Polimorfismo.Calculadora;

public class MainCalculadora {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        
        double resultado1 = c.somar(2, 3);
        double resultado2 = c.somar(2, 3, 4);
        
        System.out.println("Resultado 1: " + resultado1);
        System.out.println("Resultado 2: " + resultado2);
        
        double resultado3 = c.somar(2.5, 7);
        System.out.println("Resultado 3: " + resultado3);

    }
}
