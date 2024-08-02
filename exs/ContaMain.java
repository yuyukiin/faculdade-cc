package Conta;

/*Crie um objeto novaConta do tipo ContaCorrente.
• Chame o método definirSaldoInicial passando o valor 1000 como parâmetro.
• Escreva o valor do atributo saldo
• Realize um saque de 500 reais (utilize o método sacar).
• Faça um depósito de 50 reais (utilize o método depositar)
• Escreva o valor do atributo saldo na tela.
• Realize um saque de 600 reais.
• Escreva o valor do atributo saldo na tela */

public class ContaMain {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente();
        conta1.definirSaldoInicial(1000);
        System.out.println("Saldo: " + conta1.saldo);
        conta1.sacar(500);
        conta1.depositar(50);
        System.out.println("Saldo: " + conta1.saldo);
        conta1.sacar(600);
        System.out.println("Saldo: " + conta1.saldo);

    }
}
