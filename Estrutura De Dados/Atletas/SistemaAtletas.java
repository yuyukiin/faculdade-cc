package TrabalhoAvaliativo2;

import java.util.HashMap;
import java.util.Map;

public class SistemaAtletas {
    private Map<String, Atleta> atletas;

    public SistemaAtletas() {
        this.atletas = new HashMap<>();
    }

    public void cadastrarAtleta(Atleta atleta) {
        if (!atletas.containsKey(atleta.getFone())) {
            atletas.put(atleta.getFone(), atleta);
            System.out.println("Atleta cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Já existe um atleta cadastrado com este número de telefone.");
        }
    }

    public void listarAtletas() {
        for (Atleta atleta : atletas.values()) {
            System.out.println(atleta);
        }
    }

    public Atleta procurarAtleta(String chave) {
        return atletas.get(chave);
    }

    public void removerAtleta(String chave) {
        Atleta atletaRemovido = atletas.remove(chave);
        if (atletaRemovido != null) {
            System.out.println("Atleta removido com sucesso.");
        } else {
            System.out.println("Erro: Atleta não encontrado.");
        }
    }

    public Map<String, Atleta> getAtletas() {
        return atletas;
    }
}
