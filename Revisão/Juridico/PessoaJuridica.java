package PessoaJuridica;

public class PessoaJuridica extends Pessoa {
    protected String socio;
    protected int CNPJ, dtAbertura;

    public PessoaJuridica(String nome, int idade, String socio, int CNPJ, int dtAbertura) {
        super(nome, idade);
        this.socio = socio;
        this.CNPJ = CNPJ;
        this.dtAbertura = dtAbertura;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public int getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(int cNPJ) {
        CNPJ = cNPJ;
    }

    public int getDtAbertura() {
        return dtAbertura;
    }

    public void setDtAbertura(int dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

}
