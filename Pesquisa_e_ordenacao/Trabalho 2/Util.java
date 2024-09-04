import java.util.ArrayList;
import java.util.Random;

public class Util {
    
    /**
     * Método estático que gera um nome aleatório
     * @param tamanho - quantidade de caracteres do nome
     * @return um nome aleatório
     */
    public static String gerarNome(int tamanho) {
        StringBuilder letras = new StringBuilder("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Random gerador = new Random();
        StringBuilder nome = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            nome.append(letras.charAt(gerador.nextInt(letras.length())));
        }

        return nome.toString();
    }

    /**
     * Método estático que popula uma lista com objetos Aluno
     * @param lista - contém os objetos Aluno gerados
     * @param quantidade - quantos objetos Aluno se deseja gerar
     */
    public static void gerarAlunos(ArrayList<Aluno> lista, int quantidade) {
        Random gerador = new Random();
        for (int i = 0; i < quantidade; i++) {
            String nome = gerarNome(10); // Nome com 10 caracteres
            int idade = 18 + gerador.nextInt(53); // Idade entre 18 e 70 anos
            lista.add(new Aluno(nome, idade));
        }
    }

    /**
     * Método estático que exibe a lista de alunos
     * @param lista - contém objetos Aluno
     * @param frase - título a ser exibido pelo método
     */
    public static void exibir(ArrayList<Aluno> lista, String frase) {
        System.out.println(frase);
        for (Aluno aluno : lista) {
            System.out.println(aluno);
        }
    }
}
