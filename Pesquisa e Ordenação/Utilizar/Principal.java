package Aula;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList <Integer> listaDesordenada = new ArrayList<>();
        Util.preencheBagunca(listaDesordenada,5000);
        ArrayList <Integer> listaOrdenada = new ArrayList<>();
        Util.PreencheOrdenado(listaOrdenada, 5000);
        
        long tempoInicio = System.nanoTime();
        System.out.println("Iniicou tempo de pesquisa...");
        System.out.println(listaOrdenada.contains(2000-1));
        System.out.println("tempo (ms) cotains ordenada: "+ (System.nanoTime()- tempoInicio));
        
        tempoInicio = System.nanoTime();
        System.out.println("Iniicou tempo de pesquisa...");
        System.out.println(listaDesordenada.contains(2000-1));
        System.out.println("tempo (ms) cotains ordenada: "+ (System.nanoTime()- tempoInicio));
        
        tempoInicio = System.nanoTime();
        System.out.println("Iniicou tempo de pesquisa...");
        System.out.println(Util.pesquisaBinarioContain(1000000,listaOrdenada));
        System.out.println("tempo (ms) cotains ordenada: "+ (System.nanoTime()- tempoInicio));
        
    }
}
