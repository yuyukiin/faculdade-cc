package NewEx.Conta;
    public abstract class Conta {
        protected double saldo;
        protected double limite;

        public Conta(double saldo, double limite) {
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

        public abstract void depositar(double valor);
        public abstract void sacar(double valor);
    }

