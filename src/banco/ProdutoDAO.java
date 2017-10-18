package banco;
import java.sql.*;
import dados.*;

public class ProdutoDAO extends BancoDados {

    public boolean adicionarProduto(Produto p) {
        try {
            Statement st = conexao.createStatement();
            String strcmd = String.format("INSERT INTO Produtos VALUES (NULL,'%s','%s','%f','%s','%d')", p.getNome(),p.getDescricao(),p.getPreco(),p.getCodigoDeBarra(),p.getQuantidade());
            st.executeUpdate(strcmd);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removerProduto(String codebar) {
        try {
            Statement st = conexao.createStatement();
            String strcmd = String.format("DELETE FROM Produtos WHERE id=%s", codebar);
            st.executeUpdate(strcmd);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean atualizarProduto(Produto p) {
        try {
            removerProduto(p.getCodigoDeBarra());
            Statement st = conexao.createStatement();
            adicionarProduto(p);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void listarProdutos() {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Produtos");
            while (rs.next()) {
                System.out.println(" Produto " + rs.getString(2) +
                        "\n Descricao: "+ rs.getString(3)+
                        "\n Preço: " + rs.getString(4) +
                        "\n Codigo de barra: " + rs.getString(5) +
                        "\n Quantidade: " + rs.getString(6));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto personagem = new Produto("taigo", "lixo",
                0, "lixo 123", 1);
        produtoDAO.adicionarProduto(personagem);
        produtoDAO.listarProdutos();
    }


}
