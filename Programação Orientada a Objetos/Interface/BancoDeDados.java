package NewEx.Dados;

public class BancoDeDados implements AcessoDados {

    @Override
    public void conectar() {
        System.out.println("Conectado ao banco de dados.");
    }

    @Override
    public void desconectar() {
        System.out.println("Desconectado do banco de dados.");
    }

    @Override
    public void inserir(String dados) {
        System.out.println("Dados inseridos: " + dados);
    }

    @Override
    public void atualizar(String dados) {
        System.out.println("Dados atualizados: " + dados);
    }

    @Override
    public void excluir(String dados) {
        System.out.println("Dados excluídos: " + dados);
    }
}
