package CompareTo.Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Tei", 19));
        alunos.add(new Aluno("Gabriel", 23));
        alunos.add(new Aluno("Dudu", 20));
        alunos.add(new Aluno("Alex", 22));
        alunos.add(new Aluno("Brunim levanti", 20));
        alunos.add(new Aluno("Brunim nao levanti", 20));
                
        // Solução tradicional: usa o método compareTo na classe Aluno
        Collections.sort(alunos);

        // Solução 2: usa um Comparator sem modificar a classe Aluno
        Collections.sort(alunos, Comparator.comparing(Aluno::getNome).thenComparing(Aluno::getIdade));

        // Solução moderna: usa o método sort diretamente na lista
        alunos.sort(Comparator.comparing(Aluno::getNome).thenComparing(Aluno::getIdade));

        Ordenacao.bolha(alunos);

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

    }
}
