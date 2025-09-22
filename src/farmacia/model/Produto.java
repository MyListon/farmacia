package farmacia.model;

public class Produto {
	// Atributos
    private String nome;
    private String fabricante;
    private double preco;
    private String idProduto;
    private int quantidadeEstoque;
    private String tipoProduto;

    // Construtor
    public Produto(String nome, String fabricante, double preco, String idProduto, int quantidadeEstoque, String tipoProduto) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
        this.idProduto = idProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.tipoProduto = tipoProduto;
    }

    // Métodos para exibir informações
    public void exibirInfo() {
        System.out.println("--- Informações do Produto ---");
        System.out.println("Nome: " + nome);
        System.out.println("Fabricante: " + fabricante);
        System.out.printf("Preço: R$ %.2f\n", preco);
        System.out.println("ID: " + idProduto);
        System.out.println("Em Estoque: " + quantidadeEstoque + " unidades");
        System.out.println("Tipo: " + tipoProduto);
    }
    
    // Métodos Getters (para acessar os atributos privados)
    public String getIdProduto() {
        return idProduto;
    }
}