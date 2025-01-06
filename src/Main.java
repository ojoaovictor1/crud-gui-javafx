import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try(Connection conexao = ConexaoDB.conectar();
        Statement stmt = conexao.createStatement()){
            String comandoSql = "CREATE TABLE produtos (" +
                    "id_produtos INTEGER PRIMARY KEY," +
                    "nome_produto TEXT NOT NULL," +
                    "quantidade INTEGER," +
                    "preco REAL," +
                    "status TEXT" +
                    ");";
            System.out.println(comandoSql);

            stmt.execute(comandoSql);
            System.out.println("Tabela produtos criada com sucesso!");

        } catch(SQLException e){
            System.err.println("Erro ao criar a tabela: " + e.getMessage());
            e.printStackTrace();
        }

    }
}