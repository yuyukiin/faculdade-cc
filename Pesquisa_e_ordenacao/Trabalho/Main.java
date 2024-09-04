import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int quantidadeAlunos = 60000;
        ArrayList<Aluno> alunos = new ArrayList<>();
        Util.gerarAlunos(alunos, quantidadeAlunos);

        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha o método de ordenação:");
            System.out.println("1. Ordenação Bolha");
            System.out.println("2. Ordenação Seleção");
            System.out.println("3. Ordenação Inserção");
            System.out.println("4. Ordenação Sort (padrão do Java)");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    executarOrdenacao(alunos, "bolha");
                    break;
                case 2:
                    executarOrdenacao(alunos, "selecao");
                    break;
                case 3:
                    executarOrdenacao(alunos, "insercao");
                    break;
                case 4:
                    executarOrdenacao(alunos, "sort");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 5);

        scanner.close();
    }

    private static void executarOrdenacao(ArrayList<Aluno> alunos, String metodo) throws InterruptedException {
        ArrayList<Aluno> copia = new ArrayList<>(alunos);

        Thread ordenacaoThread = new Thread(() -> {
            switch (metodo) {
                case "bolha":
                    Ordenacao.bolha(copia);
                    Util.exibir(copia, "Ordenação Bolha:");
                    break;
                case "selecao":
                    Ordenacao.selecao(copia);
                    Util.exibir(copia, "Ordenação Seleção:");
                    break;
                case "insercao":
                    Ordenacao.insercao(copia);
                    Util.exibir(copia, "Ordenação Inserção:");
                    break;
                case "sort":
                    Collections.sort(copia, Comparator.comparing(Aluno::getNome).thenComparing(Aluno::getIdade));
                    Util.exibir(copia, "Ordenação Sort:");
                    break;
            }
        });

        ordenacaoThread.start();
        ordenacaoThread.join();
    }
}
