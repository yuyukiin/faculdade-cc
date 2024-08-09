package PessoaJuridica;

public class Principal {
    public static void main(String[] args) {
        PessoaJuridica p = new PessoaJuridica(null, 0, null, 0, 0);

        p.setNome("João");
        p.setIdade(20);
        p.setCNPJ(123456789);
        p.setSocio("Maria");
        p.setDtAbertura(14);

        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
        System.out.println("CNPJ: " + p.getCNPJ());
        System.out.println("Sócio: " + p.getSocio());
        System.out.println("Data de abertura: " + p.getDtAbertura());

    }
}
