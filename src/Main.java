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

            Produto produtoConsultado = produtoDAO.consultarPorId(1);
            if(produtoConsultado != null){
                System.out.println("Produto encontrado: " + produtoConsultado.getNome());
            }else{
                System.out.println("Produto não encontrado");
            }


        } catch(Exception e){
            System.out.println("Erro geral: " + e.getMessage());
        }


    }

    private static void mostrarProdutos(ProdutoDAO produtoDAO) {
        List<Produto> todosProdutos = produtoDAO.listarTodos();
        if(todosProdutos.isEmpty()){
            System.out.println("Nenhum produto encontrado");
        }else{
            System.out.println("lista de produtos: ");
            for (Produto p : todosProdutos){
                System.out.println(p.getId() + ": " + p.getNome() + " - " + p.getPreco());
            }
        }
    }
}