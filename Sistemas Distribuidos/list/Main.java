import java.util.*;

public class Main {
    public static void main(String[] args) {
        int totalListas = 10;      // m = número de listas
        int tamanhoLista = 1000;   // n/m = quantidade de números em cada lista

        List<List<Integer>> listaDeListas = new ArrayList<>();
        List<PopulaLista> threads = new ArrayList<>();

        // cria listas vazias
        for (int i = 0; i < totalListas; i++) {
            listaDeListas.add(new ArrayList<>());
        }

        // popula cada lista com uma thread
        for (int i = 0; i < totalListas; i++) {
            PopulaLista t = new PopulaLista(listaDeListas.get(i), tamanhoLista);
            threads.add(t);
            t.start();
        }

        // aguarda todas as threads finalizarem
        for (PopulaLista t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // calcula a média de todas as listas
        long soma = 0;
        int totalNumeros = 0;

        for (List<Integer> lista : listaDeListas) {
            for (int num : lista) {
                soma += num;
                totalNumeros++;
            }
        }

        double media = (double) soma / totalNumeros;
        System.out.println("Média de todos os valores: " + media);
    }
}

