package Conta;

//1) Crie uma classe ContaCorrente que obedeça à descrição abaixo:
/*• A classe possui o atributo saldo do tipo float e os métodos definirSaldoInicial, depositar e sacar.
• O método definirSaldoInicial deve atribuir o valor passado por parâmetro ao atribuito saldo
• O método depositar, deve adicionar o valor passado por parâmetro ao atributo saldo
• O método sacar deve reduzir o valor passado por parâmetro do saldo já existente
• Necessário verificar a condição de o valor do saldo ser insuficiente para o saque que se deseja fazer.
• O valor de retorno deve ser true (verdadeiro) quando for possível realizar o saque e false (falso)
quando não for possível (public bool sacar(float valor))/* */

public class ContaCorrente {
    public double saldo;

    public void definirSaldoInicial(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
