package TrabalhoAvaliativo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AtletaCSVDAO {
    private final String FILE_NAME = "atletas.csv";

    public void salvarDadosCSV(Map<String, Atleta> atletas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Atleta atleta : atletas.values()) {
                writer.write(atleta.getFone() + "," + atleta.getNome() + "," + atleta.getApelido() + "," +
                        atleta.getDataNascimento() + "," + atleta.getPontuacaoAcumulada());
                writer.newLine();
            }
            System.out.println("Dados salvos em atletas.csv");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados em atletas.csv: " + e.getMessage());
        }
    }

    public void carregarDadosCSV(Map<String, Atleta> atletas) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String fone = dados[0];
                String nome = dados[1];
                String apelido = dados[2];
                String dataNascimento = dados[3];
                int pontuacaoAcumulada = Integer.parseInt(dados[4]);

                Atleta atleta = new Atleta(fone, nome, apelido, dataNascimento, pontuacaoAcumulada);
                atletas.put(atleta.getFone(), atleta);
            }
            System.out.println("Dados carregados de atletas.csv");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados de atletas.csv: " + e.getMessage());
        }
    }
}
