package Polimorfismo.Calculadora;

public class MainCalculadora {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        
        //somar
        double resultado1 = c.somar(2, 3);
        double resultado2 = c.somar(2, 3, 4);
        
        //imprimir
        System.out.println("Resultado 1: " + resultado1);
        System.out.println("Resultado 2: " + resultado2);
        
        //sobrecarga
        double resultado3 = c.somar(3, 7);

        //imprimir
        System.out.println("Resultado 3: " + resultado3);

        //multiplicar
        double resultado4 = c.multiplicar(2,4);

        //imprimir  
        System.out.println("Resultado 4: " + resultado4);

        //sobrecarga
        double resultado5 = c.multiplicar(2.5, 3.5);
        
        //imprimir
        System.out.println("Resultado 5: " + resultado5);

    }
}
