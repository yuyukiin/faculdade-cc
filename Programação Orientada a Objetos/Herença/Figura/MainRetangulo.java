package Herença.Figura;

public class MainRetangulo {
    public static void main(String[] args) {
        Retangulo r = new Retangulo();

        r.setCor("Azul");
        r.setAltura(10);
        r.setLargura(20);
        r.setPreenchido("Sim");

        r.calcularArea(r.getAltura(), r.getLargura());

    }
}
