import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/SistemaPedidos";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; // Ajuste conforme sua senha do MySQL

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}

interface ProdutoRepository {
    void inserir(Produto produto);
    List<Produto> carregarTodos();
    void alterarProduto(Produto produto);
    void excluir(Produto produto);
    Produto carregar(int id);
}

interface PedidoRepository {
    void inserir(Pedido pedido);
    List<Pedido> carregarTodos();
    void alterarPedido(Pedido pedido);
    void excluir(Pedido pedido);
    Pedido carregar(int id);
}

class ProdutoRepositoryImpl implements ProdutoRepository {
    @Override
    public void inserir(Produto produto) {
        String sql = "INSERT INTO Produto (nome, preco, quantidade, categoria) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getCategoria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produto> carregarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("categoria")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public void alterarProduto(Produto produto) {
        String sql = "UPDATE Produto SET nome = ?, preco = ?, quantidade = ?, categoria = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getCategoria());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Produto produto) {
        String sql = "DELETE FROM Produto WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produto carregar(int id) {
        String sql = "SELECT * FROM Produto WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            rs.getInt("quantidade"),
                            rs.getString("categoria")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
