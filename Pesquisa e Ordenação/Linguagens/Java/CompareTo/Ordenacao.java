package CompareTo.Java;

import java.util.ArrayList;

public class Ordenacao {
    public static void pente(ArrayList<Aluno> lista) {
        int distancia = lista.size();
        Aluno tmp;
        int i;
        boolean houveTroca;
        do {
            distancia = Integer.max(1, (int) (distancia / 1.3));
            if (distancia < 1) distancia = 1;
            houveTroca = false;
            for (i = 0; i + distancia < lista.size(); i++) {
                if (lista.get(i).compareTo(lista.get(i + distancia)) > 0) {
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, tmp);
                    houveTroca = true;
                }
            }
        } while (distancia > 1 && houveTroca);
        
    }
    
    public static void bolha(ArrayList<Aluno> alunos) {
        Aluno tmp;
        int i;
        boolean houveTroca;
        do {
            houveTroca = false;
            for (i = 0; i < alunos.size() - 1; i++) {
                if (alunos.get(i).compareTo(alunos.get(i + 1)) > 0) {
                    tmp = alunos.get(i);
                    alunos.set(i, alunos.get(i + 1));
                    alunos.set(i + 1, tmp);
                    houveTroca = true;
                }
            }
        } while (houveTroca);
    }
}
