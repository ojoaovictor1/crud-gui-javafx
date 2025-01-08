import java.sql.Connection;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try(Connection conexao = ConexaoDB.conectar()){
            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

            mostrarProdutos(produtoDAO);

            Produto novoProduto1 = new Produto("Notebook", 10, 1999.99, "Em estoque");
            Produto novoProduto2 = new Produto("Smartphone", 20, 1499.99, "Extoque baixo");
            Produto novoProduto3 = new Produto("Table", 15, 799.99, "Extoque baixo");

            produtoDAO.inserir(novoProduto1);
            produtoDAO.inserir(novoProduto2);
            produtoDAO.inserir(novoProduto3);

            mostrarProdutos(produtoDAO);


        }


    }
}