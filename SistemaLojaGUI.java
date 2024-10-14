import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CRIA A INTERFACE GRAFICA DO SISTEMA DE LOJA VIRTUAL
public class SistemaLojaGUI extends JFrame {
    private Carrinho carrinho;
    private JTextArea areaCarrinho;
    private JTextField campoNomeProduto;
    private JTextField campoPrecoProduto;
    private JTextField campoQuantidadeProduto;

//CONSTRUTOR 
    public SistemaLojaGUI() {
        //INICIALIZA UM NOVO CARRINHO
        carrinho = new Carrinho(); 
        //CONFIGURA A JANELA PRINCIPAL
        configurarJanela();
        //ADICIONA OS COMPONENTES DA INTERFACE
        configurarComponentes(); 
    }

//CONFIGURA A JANELA PRINCIPAL DA APLICACAO
    private void configurarJanela() {
        setTitle("Sistema de Loja Virtual"); 
        setSize(400, 300); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLayout(new BorderLayout()); 
    }

//CONFIGURA OS COMPONENTES DA INTERFACE
    private void configurarComponentes() {
        //AREA PARA EXIBIR O CARRINHO DE COMPRAS
        areaCarrinho = new JTextArea();
        areaCarrinho.setEditable(false); 
        add(new JScrollPane(areaCarrinho), BorderLayout.CENTER);

//PAINEL DE ENTRADA PARA ADICIONAR PRODUTOS
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(4, 2)); 

//ADICIONANDO CAMPOS DE ENTRADA PARA PRODUTO
        painelEntrada.add(new JLabel("Nome do Produto:"));
        campoNomeProduto = new JTextField();
        painelEntrada.add(campoNomeProduto);

        painelEntrada.add(new JLabel("Preço:"));
        campoPrecoProduto = new JTextField();
        painelEntrada.add(campoPrecoProduto);

        painelEntrada.add(new JLabel("Quantidade:"));
        campoQuantidadeProduto = new JTextField();
        painelEntrada.add(campoQuantidadeProduto);

//BOTAO PARA ADICIONAR O PRODUTO AO CARRINHO
        JButton botaoAdicionar = new JButton("Adicionar ao Carrinho");
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto(); //CHAMA O METODO PARA ADICIONAR PRODUTO
            }
        });

        painelEntrada.add(botaoAdicionar); //ADICIONA O BOTAO AO PAINEL
        add(painelEntrada, BorderLayout.SOUTH);
    }

//METODO QUE ADICIONA UM PRODUTO AO CARRINHO
    private void adicionarProduto() {
    //OBTEM OS VALORES DOS CAMPOS DE TEXTO
        String nome = campoNomeProduto.getText();
        double preco = Double.parseDouble(campoPrecoProduto.getText());
        int quantidade = Integer.parseInt(campoQuantidadeProduto.getText());

    //CRIA UM NOVO PRODUTO E ADICIONA AO CARRINHO
        Produto produto = new Produto(nome, preco, quantidade);
        carrinho.adicionarProduto(produto);

    //ATUALIZA A AREA DE TEXTO DO CARRINHO
        atualizarCarrinho();
    }

//METODO QUE ATUALIZA O CONTEÚDO DO CARRINHO NA INTERFACE GRAFICA
    private void atualizarCarrinho() {
        areaCarrinho.setText(""); 
        for (Produto produto : carrinho.getProdutos()) {
            areaCarrinho.append(produto.getNome() + " - Quantidade: " + produto.getQuantidade() + " - Preço: " + produto.getPreco() + "\n");
        }

        //MOSTRA O TOTAL DA COMPRA
        double total = carrinho.calcularTotal();
        areaCarrinho.append("\nTotal da Compra: R$ " + total);
    }

    //METODO MAIN PARA EXECUTAR O SISTEMA
    public static void main(String[] args) {
        // INICIA A INTERFACE GRAFICA NA THREAD ADEQUADA
        SwingUtilities.invokeLater(() -> {
            SistemaLojaGUI gui = new SistemaLojaGUI(); // CRIA A JANELA
            gui.setVisible(true); // TORNA A JANELA VISIVEL
        });
    }
}

