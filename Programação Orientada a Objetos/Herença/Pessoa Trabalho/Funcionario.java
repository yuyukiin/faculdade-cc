package Herença.PessoaTrabalho;

public class Funcionario extends Pessoa {
    
    public Funcionario(String nome){
        super(nome);
    }

    public void Trabalhar(){
        System.out.println("O funcionario está trabalhando!");
    }
    
}
