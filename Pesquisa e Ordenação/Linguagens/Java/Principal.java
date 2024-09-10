package JAVA;
import java.util.ArrayList;

public class Principal {

    /**
     * Método principal
     * @param args - argumentos
     */

    public static void main(String[] args) {
        // gerar n numeros de range m
        // gerar n palavras de tamanho m
        // arrayList<String> palavras = new ArrayList<>();
        // Util.gerarPalavras(palavras, 10, 8);

        ArrayList<String> palavras = new ArrayList<>();
        Util.gerarPalavrasLista(palavras, 10, 8);
        Util.exibir(palavras, "Palavras geradas:");
        
    }
}
