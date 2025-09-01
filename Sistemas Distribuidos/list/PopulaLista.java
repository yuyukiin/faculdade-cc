import java.util.*;

class PopulaLista extends Thread {
    private List<Integer> lista;
    private int tamanho;

    public PopulaLista(List<Integer> lista, int tamanho) {
        this.lista = lista;
        this.tamanho = tamanho;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            int valor = 1000 + rand.nextInt(100000 - 1000 + 1); 
            lista.add(valor);
        }
    }
}
