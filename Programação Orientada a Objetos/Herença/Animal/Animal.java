package Herença.Humano;

public class Animal {
    protected String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void Andar(){
        System.out.println("Andando!");
    }
    
}
