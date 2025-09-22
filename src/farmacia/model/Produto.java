package farmacia.model;

public class Produto {
    private String nome;
    private String fabricante;
    private double preco;
    private String idProduto;
    private int quantidadeEstoque;
    private String tipoProduto;

    public Produto(String nome, String fabricante, double preco, String idProduto, int quantidadeEstoque, String tipoProduto) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
        this.idProduto = idProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.tipoProduto = tipoProduto;
    }

    public void exibirInfo() {
        System.out.println("--- Informações do Produto ---");
        System.out.println("Nome: " + nome);
        System.out.println("Fabricante: " + fabricante);
        System.out.printf("Preço: R$ %.2f\n", preco);
        System.out.println("ID: " + idProduto);
        System.out.println("Em Estoque: " + quantidadeEstoque + " unidades");
        System.out.println("Tipo: " + tipoProduto);
    }
    
    // Getters
    public String getNome() { return nome; }
    public String getFabricante() { return fabricante; }
    public double getPreco() { return preco; }
    public String getIdProduto() { return idProduto; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public String getTipoProduto() { return tipoProduto; }
    
    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
    public void setTipoProduto(String tipoProduto) { this.tipoProduto = tipoProduto; }
    // Nota: O ID geralmente não é alterado, por isso não tem um 'setter'.
}