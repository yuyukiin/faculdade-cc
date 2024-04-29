package Exemplos;
import java.util.Scanner;

public class AlunoMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe o nome do aluno:");
        String nome = sc.nextLine();
        
        System.out.println("Informe a nota 1:");
        int nota1 = sc.nextInt();
        
        System.out.println("Informe a nota 2:");
        int nota2 = sc.nextInt();
        
        System.out.println("Informe a nota 3:");
        int nota3 = sc.nextInt();
        
        Aluno aluno = new Aluno(nome, nota1, nota2, nota3);

        System.out.println("Notas");
        System.out.println(aluno.getNome());
        System.out.println(aluno.getNota1());
        System.out.println(aluno.getNota2());
        System.out.println(aluno.getNota3());

        System.out.println("Média do(a) " + aluno.getNome() + ": " + aluno.calculaMedia());

        sc.close();
    }
}
