import java.util.TreeSet;

import javax.swing.JOptionPane;

class Aluno implements Comparable<Aluno>{
    int matricula;
    String nome;

    public Aluno(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + matricula;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (matricula != other.matricula)
            return false;
        return true;
    }

    @Override
    public int compareTo(Aluno o) {
        if(this.matricula < o.matricula){
            return -1;
        }else if(this.matricula > o.matricula){
            return 1;
        }else{
            return 0;
        }
    }
}

public class Arvore {
    public static void main(String[] args) {
        TreeSet<Aluno> arvore = new TreeSet<>();
        arvore.add(new Aluno(20, "Yuri"));
        arvore.add(new Aluno(10, "João"));
        arvore.add(new Aluno(30, "Maria"));
        arvore.add(new Aluno(5, "Pedro"));
        arvore.add(new Aluno(15, "Ana"));

        for (Aluno aluno : arvore) {
            System.out.println(aluno);
        }

        int matricula;
        String nome;
        for (int i = 0; i < 5; i++){
            // O que JOPtionPane.showInputDialog retorna é uma String, então é necessário fazer o parse para int            
            matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite a matricula do aluno: "));
            nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
            Aluno aluno = new Aluno(matricula, nome);
            if (!arvore.contains(aluno)){
                arvore.add(aluno);
            }else{
                JOptionPane.showMessageDialog(null, "Aluno já cadastrado!");
                System.gc();
            }
        }
    }
}