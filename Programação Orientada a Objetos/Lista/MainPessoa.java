package Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MainPessoa {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

        Pessoa pessoa = new Pessoa("João", 25);
        Pessoa pessoa1 = new Pessoa("Yuri", 21);
        Pessoa pessoa2 = new Pessoa("Maria", 30);

        listaPessoas.add(pessoa);
        listaPessoas.add(pessoa1);
        listaPessoas.add(pessoa2);

        ExibirPessoas(listaPessoas); // Passa a lista de pessoas como argumento para o método meuMetodo
    }
    
    public static void ExibirPessoas(List<Pessoa> lista) { // Método que recebe uma lista de pessoas como argumento
        
        for(Pessoa p : lista){
        System.out.println("Nome: " + p.getNome()); // Acessa o método getNome do objeto p
        System.out.println("Idade: " + p.getIdade()); // Acessa o método getIdade do objeto p
        }
    }
    
    private static void ExibirPessoas2(List<Pessoa> lista){
        for(int i = 0; i < lista.size(); i++){
            System.out.println("Nome: " + lista.get(i).getNome());
            System.out.println("Idade: " + lista.get(i).getIdade());
        }
    }
    
}

