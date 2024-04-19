package EstruturaDeDados;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

public class HashAluno{   
    public static void main (String[] args){
        //ArrayList<String> ListaNomes = new ArrayList<String>();
        HashSet<Aluno> HashAluno = new HashSet<Aluno>();
        HashAluno.add(new Aluno(1, "pedro"));

        for (Aluno item : HashAluno) {
            System.out.println(item);
        }

        Aluno obj = new Aluno (1, "carla");

        if (HashAluno.contains(obj)){
            System.out.println("Encontrado ");
        } else {
            System.out.println("Não encontrado");
        }

        }
    }
