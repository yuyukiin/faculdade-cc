package NewEx.Conta;

public class MainConta {
    public static void main(String[] args) {
        Conta contaInvestimento = new ContaInvestimento(1000, 500);
        Conta contaCorrente = new ContaCorrente(1000, 500);

        contaInvestimento.depositar(200);
        contaInvestimento.sacar(300);

        contaCorrente.depositar(300);
        contaCorrente.sacar(1500);
    }
}