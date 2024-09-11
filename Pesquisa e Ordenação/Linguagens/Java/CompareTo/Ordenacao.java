package CompareTo.Java;

import java.util.ArrayList;

public class Ordenacao {
    public static void pente() {
        
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
