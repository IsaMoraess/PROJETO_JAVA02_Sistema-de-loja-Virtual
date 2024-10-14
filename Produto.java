//REPRESENTA UM PRODUTO COM NOME, PREÇO E QUANTIDADE
public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

//CONSTRUTOR
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

//METODO PARA OBTER O NOME DO PRODUTO
    public String getNome() {
        return nome;
    }

//METODO PARA OBTER O PREÇO DO PRODUTO
    public double getPreco() {
        return preco;
    }

//METODO PARA OBTER A QUANTIDADE DO PRODUTO
    public int getQuantidade() {
        return quantidade;
    }
}
