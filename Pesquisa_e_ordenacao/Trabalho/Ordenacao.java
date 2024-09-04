import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe responsável por implementar diferentes métodos de ordenação.
 */
public class Ordenacao {

    /**
     * Ordena uma lista de objetos Aluno usando o algoritmo de ordenação Bolha.
     * A ordenação é feita primeiro pelo nome e, em caso de empate, pela idade.
     *
     * @param lista a lista de objetos Aluno a ser ordenada
     */
    public static void bolha(ArrayList<Aluno> lista) {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                Aluno atual = lista.get(i);
                Aluno proximo = lista.get(i + 1);
                if (atual.getNome().compareTo(proximo.getNome()) > 0 ||
                    (atual.getNome().compareTo(proximo.getNome()) == 0 && atual.getIdade() > proximo.getIdade())) {
                    Collections.swap(lista, i, i + 1);
                    houveTroca = true;
                }
            }
        } while (houveTroca);
    }

    /**
     * Ordena uma lista de objetos Aluno usando o algoritmo de ordenação por Seleção.
     * A ordenação é feita primeiro pelo nome e, em caso de empate, pela idade.
     *
     * @param lista a lista de objetos Aluno a ser ordenada
     */
    public static void selecao(ArrayList<Aluno> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            int posMenor = i;
            for (int j = i + 1; j < lista.size(); j++) {
                Aluno atual = lista.get(j);
                Aluno menor = lista.get(posMenor);
                if (atual.getNome().compareTo(menor.getNome()) < 0 ||
                    (atual.getNome().compareTo(menor.getNome()) == 0 && atual.getIdade() < menor.getIdade())) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                Collections.swap(lista, i, posMenor);
            }
        }
    }

    /**
     * Ordena uma lista de objetos Aluno usando o algoritmo de ordenação por Inserção.
     * A ordenação é feita primeiro pelo nome e, em caso de empate, pela idade.
     *
     * @param lista a lista de objetos Aluno a ser ordenada
     */
    public static void insercao(ArrayList<Aluno> lista) {
        for (int i = 1; i < lista.size(); i++) {
            Aluno chave = lista.get(i);
            int j = i - 1;
            while (j >= 0 && (lista.get(j).getNome().compareTo(chave.getNome()) > 0 ||
                    (lista.get(j).getNome().compareTo(chave.getNome()) == 0 && lista.get(j).getIdade() > chave.getIdade()))) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            lista.set(j + 1, chave);
        }
    }
}
