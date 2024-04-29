package Exercícios;

public class ContaBancaria {
    private double saldo;
    private double limite;
    
    public ContaBancaria(double saldo, double limite) {
        super();
        this.saldo = saldo;
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public boolean saque(double valor) {
        if (valor <= saldo + limite) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return false;
        }
    }
}
