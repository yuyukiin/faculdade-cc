package Exercícios;

public class CarroAceleraFreiaMain {

    public static void main(String[] args) {
        CarroAceleraFreia carro = new CarroAceleraFreia("ABC1234");
        
        System.out.println("Placa do Carro: " + carro.getPlaca());
        System.out.println("Velocidade do Carro: " + carro.getVelocidade());
        
        carro.acelerar(50);
        System.out.println("Velocidade do Carro após acelerar: " + carro.getVelocidade());
        
        carro.freiar(20);
        System.out.println("Velocidade do Carro após freiar: " + carro.getVelocidade());
    }
}
