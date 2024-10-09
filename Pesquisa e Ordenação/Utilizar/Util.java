package Aula;
import java.util.ArrayList;
import java.util.Random;

public class Util {
    
    /**
     * @param lista
     * @param n
     */
    public static void PreencheOrdenado(ArrayList<Integer> lista, int n){

        for(int i = 0;i < n;i++ ){
            
            lista.add(i);

        }

    }

    public static void preencheBagunca(ArrayList<Integer> lista, int n){

        for(int i = 0;i < n;i++ ){
            
            Random r = new Random();
            lista.add(r.nextInt(1000));

        }

    }
    
    public static int pesquisaBinarioContain(int valor, ArrayList<Integer> lista){
        
        int ini = 0;
        int fim = lista.size() - 1;
        int meio;
        
        while(ini <= fim){
            
            meio = (int)((ini+fim)/2);
            if(valor == lista.get(meio)){
                
                return meio;
                
            }
            if(valor < meio){
                
                fim = meio-1;
                
            }else{
                
                ini = meio + 1;
                
            }
            
            
        }
        return -1;
    }
