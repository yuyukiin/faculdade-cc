package Animal;

public class Cachorro extends Animal{
    protected String raca;

    public Cachorro(String nome, String som, int idade, String raca) {
        super(nome, som, idade);
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    public void latir(){
        System.out.println("Au au");
    }
}
