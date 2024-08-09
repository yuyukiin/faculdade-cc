package Carro;

public class Principal {
    public static void main(String[] args) {
        Onibus o = new Onibus("Marcopolo", "Benz");
        o.setMarca("Marcopolo");
        o.setModelo("Benz");

        o.exibirMsg();

        System.out.println("Marca: " + o.getMarca());
        System.out.println("Modelo: " + o.getModelo());
    }
}
