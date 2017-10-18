package banco;
import java.sql.*;

/**Classe responsavel por criar a conexao com o banco de dados.*/
public class BancoDados {
	private static String url = "jdbc:mysql://localhost:3306/GestaoEstoque";
	private static String user = "gestao_admin";
    private static String password = "acesso123";
	
	/**Objeto utilizado para criar uma conexao com o banco de dados, executando comandos SQL.*/
    protected static Connection conexao;
    
    public BancoDados(){
        if(conexao == null)
            conecta();
    }
    
    private static boolean conecta(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.print(e.getMessage());
            System.exit(1);
        }
        
        try {
            conexao = DriverManager.getConnection(url, user, password);
            return true;
        }catch(SQLException e){
            System.out.print(e.getMessage());
            System.exit(1);
            return false;
        }
    }
    
	/**Metodo responsavel por encerrar a conexao com o banco de dados*/
    public static boolean desconecta(){
        try{
            conexao.close();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
