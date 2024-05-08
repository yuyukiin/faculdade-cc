package TrabalhoAvaliativo2;

import java.util.Scanner;

public class MainAtleta {
    public static void main(String[] args) {
        SistemaAtletas sistema = new SistemaAtletas();
        AtletaCSVDAO dao = new AtletaCSVDAO();
        Scanner scanner = new Scanner(System.in);

        dao.carregarDadosCSV(sistema.getAtletas());

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Listar atletas");
            System.out.println("2 - Cadastrar atleta");
            System.out.println("3 - Procurar por atleta por nome");
            System.out.println("4 - Remover atleta por nome");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    sistema.listarAtletas();
                    break;
                case 2:
                    cadastrarAtleta(sistema, scanner);
                    break;
                case 3:
                    procurarAtletaPorNome(sistema, scanner);
                    break;
                case 4:
                    removerAtletaPorNome(sistema, scanner);
                    break;
                case 0:
                    dao.salvarDadosCSV(sistema.getAtletas());
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarAtleta(SistemaAtletas sistema, Scanner scanner) {
        System.out.println("\nCadastro de Atleta");
        System.out.println("Digite o número de telefone do atleta:");
        String fone = scanner.nextLine();
        System.out.println("Digite o nome do atleta:");
        String nome = scanner.nextLine();
        System.out.println("Digite o apelido do atleta:");
        String apelido = scanner.nextLine();
        System.out.println("Digite a data de nascimento do atleta:");
        String dataNascimento = scanner.nextLine();
        System.out.println("Digite a pontuação acumulada do atleta:");
        int pontuacaoAcumulada = scanner.nextInt();
        scanner.nextLine(); 

        Atleta atleta = new Atleta(fone, nome, apelido, dataNascimento, pontuacaoAcumulada);
        sistema.cadastrarAtleta(atleta);
    }

    private static void procurarAtletaPorNome(SistemaAtletas sistema, Scanner scanner) {
        System.out.println("\nProcurar Atleta por Nome");
        System.out.println("Digite o nome do atleta:");
        String nome = scanner.nextLine();
        Atleta encontrado = sistema.procurarAtleta(nome);
        if (encontrado != null) {
            System.out.println("Atleta encontrado: " + encontrado);
        } else {
            System.out.println("Atleta não encontrado.");
        }
    }
    
    private static void removerAtletaPorNome(SistemaAtletas sistema, Scanner scanner) {
        System.out.println("\nRemover Atleta por Nome");
        System.out.println("Digite o nome do atleta:");
        String nome = scanner.nextLine();
        Atleta atleta = sistema.procurarAtleta(nome);
        if (atleta != null) {
            sistema.removerAtleta(atleta.getFone());
            System.out.println("Atleta removido com sucesso.");
        } else {
            System.out.println("Atleta não encontrado.");
        }
    }
}
