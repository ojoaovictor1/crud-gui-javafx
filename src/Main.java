import java.sql.Connection;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try(Connection conexao = ConexaoDB.conectar()){
            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

            mostrarProdutos(produtoDAO);



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