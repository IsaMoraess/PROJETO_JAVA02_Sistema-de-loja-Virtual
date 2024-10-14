import java.util.ArrayList;
import java.util.List;

//ARMAZENA PRODUTOS E CALCULA O TOTAL DA COMPRA
public class Carrinho {
    private List<Produto> produtos;

//CONSTRUTOR INICIALIZA A LISTA DE PRODUTOS
    public Carrinho() {
        produtos = new ArrayList<>();
    }

//METODO PARA ADICIONAR UM PRODUTO AO CARRINHO
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

//METODO PARA OBTER A LISTA DE PRODUTOS NO CARRINHO
    public List<Produto> getProdutos() {
        return produtos;
    }

//METODO PARA CALCULAR O TOTAL DA COMPRA
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade(); 
        }
        return total;
    }
}
