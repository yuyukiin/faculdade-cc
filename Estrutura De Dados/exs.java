package Aula;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

public class exs{   
    public static void main (String[] args){
        ArrayList<String> ListaNomes = new ArrayList<String>();
        HashSet<String> HashNomes = new HashSet<String>();
        String nome;

        for (int i = 0; i < 5; i++){
            nome = JOptionPane.showInputDialog(null, "Digite um nome: ").toUpperCase();

            if (!HashNomes.add(nome)){
                JOptionPane.showMessageDialog(null, "Este nome ja foi cadastrado ");
            }

        }

        ListaNomes.addAll(HashNomes);
        ListaNomes.sort(null);

        StringBuilder resultado = new StringBuilder();
        
        for (String item : ListaNomes){
            resultado.append(item).append(" Armazenado na posição ").append( item.hashCode() ).append(" \n ");
        }
        
        JOptionPane.showMessageDialog(null, resultado);

        System.exit(0);

        }
    }
