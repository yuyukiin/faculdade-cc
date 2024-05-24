import java.util.ArrayList;

public class Recursao { 
    
    public static void exibirR(int i){ //Inicialização da variável de controle é no parametro
        if(i > 0) { //teste de parada da recursão
            System.out.println("Empilhando");
            exibirR(i - 1); // Transformação da variável de controle ocorre no ponto de recursão
        }
        System.out.println("Desempilhando");
    }

    public static void imprimirR(int i) { //Inicialização da variável de controle é no parametro
        if(i > 0) { //teste de parada da recursão
            imprimirR(i - 1);
            System.out.println(i);
        }
    }

    public static void exibirVetorR(int []vetor, int i) { //Inicialização da variável de controle é no parametro
        if(i >= 0) { //teste de parada da recursão
            exibirVetorR(vetor, i - 1); // Transformação da variável de controle ocorre no ponto de recursão
            System.out.println(vetor[i]);
        }
    } 

    public static void exibirDecrescenteR(ArrayList<String> lista, int n) {
        if (n > 0) {
            System.out.println(lista.get(n));
            exibirDecrescenteR(lista, n - 1);
        }
    }

    public static void imprimirNomesGrandes(ArrayList<String> lista, int n, int tamanho) {
        if (n > 0) {
            if (lista.get(n - 1).length() > tamanho) { //Length retorna o tamanho da string
                System.out.println(lista.get(n - 1));
            }
            imprimirNomesGrandes(lista, n - 1, tamanho);
        }
    }
        
    public static void main(String[] args) {
      
        // for(int i = 0; i < 3; i++) {
        //  System.out.println("Empilhando");
        //}

        //exibirR(3);

        //imprimirR(4);
    

        //int []vetor = {4,5,6,7};

       //exibirVetorR(vetor, vetor.length - 1);

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Yuri Bagual");
        lista.add("Angela");
        lista.add("Gigi");
        lista.sort(null);

        //exibirDecrescenteR(lista, lista.size());

        imprimirNomesGrandes(lista, lista.size(), 5);

    }
}