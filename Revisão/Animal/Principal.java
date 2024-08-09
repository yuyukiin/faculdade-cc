package Animal;

public class Principal {
    public static void main(String[] args) {
        Cachorro c = new Cachorro("Rex", "Au au", 5, "Vira-lata");

        c.setIdade(9);
        c.setNome("Juerto");
        c.setRaca("Leoni");
        c.setSom("AUUUU");
        c.latir();
    }
}
