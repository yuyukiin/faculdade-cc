package JAVA;
import java.util.ArrayList;
import java.util.Random;

public class Util {

    // Variável estática para letras
    private static final StringBuilder letras = new StringBuilder("abcdefghijklmnopqrstuvwxyz ");
    private static final Random gerador = new Random();

    /**
     * Método que gera palavras aleatórias
     * 
     * @param tamanho - tamanho da palavra
     * @return palavra gerada
     */
    public static String gerarPalavras(int tamanho) {
        StringBuilder palavra = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            palavra.append(letras.charAt(gerador.nextInt(letras.length())));
        }

        return palavra.toString();
    }

    /**
     * Método que gera palavras aleatórias
     * 
     * @param palavras   - lista de palavras
     * @param quantidade - quantidade de palavras a serem geradas
     * @param tamanho    - tamanho da palavra
     */
    public static void gerarPalavrasLista(ArrayList<String> palavras, int quantidade, int tamanho) {
        for (int i = 0; i < quantidade; i++) {
            palavras.add(gerarPalavras(tamanho));
        }
    }

    /**
     * Método que exibe uma lista de palavras
     * 
     * @param lista - lista de palavras
     * @param frase - frase a ser exibida antes da lista
     */
    public static void exibir(ArrayList<String> lista, String frase) {
        System.out.println(frase);
        for (String palavra : lista) {
            System.out.println(palavra);
        }
    }
}
