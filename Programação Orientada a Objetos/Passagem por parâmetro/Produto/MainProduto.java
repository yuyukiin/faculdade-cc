import Produto.Produto;

public class MainProduto {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Arroz", 10.0);
        Produto produto2 = produto1.clone();

        System.out.println("Produto 1 - Nome "+ produto1.getNome() + " - Preço: " + produto1.getPreco());
        System.out.println("Produto 2 - Nome " + produto2.getNome() + " - Preço: " + produto2.getPreco());

        produto2.setNome("Feijão");
        produto2.setPreco(25.0);

        System.out.println("Produto 1 - Nome "+ produto1.getNome() + " - Preço: " + produto1.getPreco());
        System.out.println("Produto 2 - Nome " + produto2.getNome() + " - Preço: " + produto2.getPreco());
    }
}
