package Polimorfismo;

public class Principal {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.fazerSom();

        Cachorro c = new Cachorro();
        c.fazerSom();

        Rino r = new Rino();
        r.fazerSom();
    }
}
