package Exemplos;

public class Aluno {
    private String nome;
    private int nota1, nota3, nota2;

    public Aluno(String nome, int nota1, int nota3, int nota2) {
        super();
        this.nome = nome;
        this.nota1 = nota1;
        this.nota3 = nota3;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public double calculaMedia () {
        return (this.nota1 + this.nota2 + this.nota3) / 3.0;
    }
}
