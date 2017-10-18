package banco;
import java.sql.*;
import dados.*;

public class CompraDAO extends BancoDados{
    public boolean adicionarCompra(Compra c) {
        try {
            Statement st = conexao.createStatement();
            String strcmd = String.format("INSERT INTO Compras VALUES (NULL,'%d','%f','%s','%f','%d', '%s','%s')", c.getIdCompra(),c.getPrecoCompra(),c.getUnidadeDeMedida(),c.getPrecoDeVenda(),c.getQuantidade(),c.getProduto().getNome(),c.getDataDaCompra());
            st.executeUpdate(strcmd);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removerCompra(int idCompra) {
        try {
            Statement st = conexao.createStatement();
            String strcmd = String.format("DELETE FROM Compras WHERE id=%d", idCompra);
            st.executeUpdate(strcmd);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean atualizarCompra(Compra compra) {
        try {
            removerCompra(compra.getIdCompra());
            Statement st = conexao.createStatement();
            adicionarCompra(compra);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void listarCompras() {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Compras");
            while (rs.next()) {
                System.out.println(" idCompŕa " + rs.getString(2) +
                        "\n Preço da Compra: "+ rs.getString(3)+
                        "\n Unidade de medida: " + rs.getString(4) +
                        "\n Preco de Venda: " + rs.getString(5) +
                        "\n Quantidade: " + rs.getString(6)+
                        "\n Descricao: " + rs.getString(7)+
                        "\n Data da Compra: " + rs.getString(8));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        CompraDAO compraDAO = new CompraDAO();
        Produto personagem = new Produto("taigo", "lixo",
                0, "lixo 123", 1);
        Compra compra = new Compra("kg", 4.0, 2, personagem, "24/01/2017", 1);
        compraDAO.adicionarCompra(compra);
        compraDAO.listarCompras();
    }
}
