import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL_JDBC_PADRAO = "jdbc:sqlite:meu_banco_de_dados.bd";

    public static Connection conectar(){
        try {
            return DriverManager.getConnection(URL_JDBC_PADRAO);
        } catch (SQLException e){
            System.err.println("Erro ao conectar no bando de dadoos: " + e.getMessage());
            return null;
        }

    }

    public static Connection conectarGenerico(String url, String usuario, String senha){
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch(SQLException e){
            System.err.println("Erro ao conectar ao bando de dados genérico: " + e.getMessage());
            return null;
        }
    }
}
