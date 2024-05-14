package Polimorfismo.Animais;

public class SobrescritaExemplo {
    public static void main(String[] args) {

        Animal a = new Animal();
        a.fazerSom();

        a = new Cachorro();
        Cachorro c = new Cachorro();
        c.fazerSom();

        a = new Peixe();
        Peixe p = new Peixe();
        p.fazerSom();

        a = new Hipopotamo();
        Hipopotamo h = new Hipopotamo();
        h.fazerSom();

        a = new Passarinho();
        Passarinho pa = new Passarinho();
        pa.fazerSom();
        
    }
}
