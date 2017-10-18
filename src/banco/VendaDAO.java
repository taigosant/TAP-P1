package banco;
import java.sql.*;
import dados.*;

public class VendaDAO extends BancoDados {

    public boolean adicionarVenda(Venda c) {
        try {
            Statement st = conexao.createStatement();
            String strcmd = String.format("INSERT INTO Vendas VALUES (NULL,'%d','%s','%d','%s','%f', '%f','%s')", c.getIdVenda(),c.getProduto().getNome(),c.getQuantidade(),c.getTipoDePagamento(),c.getTotalPagamento(),c.getTroco(),c.getDataDaVenda());
            st.executeUpdate(strcmd);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removerVenda(int idVenda) {
        try {
            Statement st = conexao.createStatement();
            String strcmd = String.format("DELETE FROM Vendas WHERE id=%d", idVenda);
            st.executeUpdate(strcmd);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean atualizarVenda(Venda venda) {
        try {
            removerVenda(venda.getIdVenda());
            Statement st = conexao.createStatement();
            adicionarVenda(venda);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void listarVendas() {
        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Vendas");
            while (rs.next()) {
                System.out.println(" idVenda " + rs.getString(2) +
                        "\n Descricao: "+ rs.getString(3)+
                        "\n Quantidade: " + rs.getString(4) +
                        "\n tipo de pagamento: " + rs.getString(5) +
                        "\n total pagamento: " + rs.getString(6)+
                        "\n troco: " + rs.getString(7)+
                        "\n Data da Venda: " + rs.getString(8));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        VendaDAO compraDAO = new VendaDAO();
        Produto personagem = new Produto("taigo", "lixo",
                0, "lixo 123", 1);
        Venda compra = new Venda(123, "diero", 100, 2, "24/01/2017", personagem, 2);
        compraDAO.adicionarVenda(compra);
        compraDAO.listarVendas();
    }
}
