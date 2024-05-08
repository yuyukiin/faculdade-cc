package TrabalhoAvaliativo2;

public class Atleta {
    private String fone; // Chave primária
    private String nome;
    private String apelido;
    private String dataNascimento;
    private int pontuacaoAcumulada;

    public Atleta(String fone, String nome, String apelido, String dataNascimento, int pontuacaoAcumulada) {
        this.fone = fone;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.pontuacaoAcumulada = pontuacaoAcumulada;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getPontuacaoAcumulada() {
        return pontuacaoAcumulada;
    }

    public void setPontuacaoAcumulada(int pontuacaoAcumulada) {
        this.pontuacaoAcumulada = pontuacaoAcumulada;
    }

    @Override
    public String toString() {
        return "Atleta{" + "fone='" + fone + '\'' + ", nome='" + nome + '\'' + ", apelido='" + apelido + '\'' + 
                ", dataNascimento='" + dataNascimento + '\'' + ", pontuacaoAcumulada=" + pontuacaoAcumulada + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atleta atleta = (Atleta) o;
        return fone.equals(atleta.fone);
    }

    @Override
    public int hashCode() {
        return fone.hashCode();
    }
}
