package Aula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {

        ArrayList <Integer> listaOrdenada = new ArrayList<>();
        Util.PreencheOrdenado(listaOrdenada, 2000000);

        ArrayList <Integer> listaDesordenada = new ArrayList<>();
        Util.preencheBagunca(listaDesordenada,2000000);

        TreeSet<Integer> arvore = new TreeSet<>();
        Util.preencheArvore(arvore,2000000);
        System.out.println(arvore.contains(2000000-1));
        
        long tempoInicio = System.nanoTime();
        System.out.println("Iniicou tempo de pesquisa lista ordenada ARVORE...");
        System.out.println(arvore.contains(2000000-1));

        System.out.println("tempo (ms) cotains ordenada: "+ (System.nanoTime()- tempoInicio));
        
        tempoInicio = System.nanoTime();
        System.out.println("Inicou tempo de pesquisa lista desordenada SORT...");
        System.out.println(listaDesordenada.contains(2000000-1));
        Collections.sort(listaDesordenada);
        System.out.println("tempo (ms) cotains desordenada: "+ (System.nanoTime()- tempoInicio));
        

        /*
        tempoInicio = System.nanoTime();
        System.out.println("Iniicou tempo de pesquisa...");
        System.out.println(Util.pesquisaBinarioContain(1000000,listaOrdenada));
        System.out.println("tempo (ms) cotains ordenada: "+ (System.nanoTime()- tempoInicio));
         */

        
    }
}
