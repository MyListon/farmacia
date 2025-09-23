package farmacia.model;

/**
 * A classe `Produto` representa um item genérico disponível na farmácia.
 * Ela armazena informações essenciais como nome, fabricante, preço e quantidade em estoque.
 */
public class Produto {
    // Atributos privados para encapsulamento.
    // Isso significa que eles só podem ser acessados e modificados por meio de métodos da própria classe.
    private String nome;
    private String fabricante;
    private double preco;
    private String idProduto;
    private int quantidadeEstoque;
    private String tipoProduto;

    /**
     * Construtor da classe `Produto`.
     * Usado para criar uma nova instância de produto, inicializando todos os seus atributos.
     *
     * @param nome O nome comercial do produto.
     * @param fabricante O nome da empresa que fabricou o produto.
     * @param preco O preço de venda do produto.
     * @param idProduto Um identificador único para o produto.
     * @param quantidadeEstoque O número de unidades do produto disponíveis no estoque.
     * @param tipoProduto A categoria do produto (ex: "medicamento", "cosmético").
     */
    public Produto(String nome, String fabricante, double preco, String idProduto, int quantidadeEstoque, String tipoProduto) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
        this.idProduto = idProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.tipoProduto = tipoProduto;
    }

    /**
     * Exibe todas as informações do produto formatadas de maneira legível no console.
     */
    public void exibirInfo() {
        System.out.println("--- Informações do Produto ---");
        System.out.println("Nome: " + nome);
        System.out.println("Fabricante: " + fabricante);
        // Formata o preço com duas casas decimais.
        System.out.printf("Preço: R$ %.2f\n", preco);
        System.out.println("ID: " + idProduto);
        System.out.println("Em Estoque: " + quantidadeEstoque + " unidades");
        System.out.println("Tipo: " + tipoProduto);
    }

    // --- Métodos de Acesso (Getters) ---
    // Fornecem acesso de leitura aos atributos privados.
    
    /**
     * Retorna o nome do produto.
     * @return O nome do produto.
     */
    public String getNome() { return nome; }
    
    /**
     * Retorna o nome do fabricante.
     * @return O nome do fabricante.
     */
    public String getFabricante() { return fabricante; }
    
    /**
     * Retorna o preço do produto.
     * @return O preço do produto.
     */
    public double getPreco() { return preco; }
    
    /**
     * Retorna o ID único do produto.
     * @return O ID do produto.
     */
    public String getIdProduto() { return idProduto; }
    
    /**
     * Retorna a quantidade de unidades em estoque.
     * @return A quantidade em estoque.
     */
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    
    /**
     * Retorna o tipo de produto.
     * @return O tipo de produto.
     */
    public String getTipoProduto() { return tipoProduto; }
    
    // --- Métodos de Modificação (Setters) ---
    // Fornecem a capacidade de modificar os atributos privados.

    /**
     * Define um novo nome para o produto.
     * @param nome O novo nome do produto.
     */
    public void setNome(String nome) { this.nome = nome; }
    
    /**
     * Define um novo fabricante para o produto.
     * @param fabricante O novo fabricante do produto.
     */
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }
    
    /**
     * Define um novo preço para o produto.
     * @param preco O novo preço do produto.
     */
    public void setPreco(double preco) { this.preco = preco; }
    
    /**
     * Define uma nova quantidade em estoque.
     * @param quantidadeEstoque A nova quantidade de unidades em estoque.
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
    
    /**
     * Define um novo tipo para o produto.
     * @param tipoProduto O novo tipo do produto.
     */
    public void setTipoProduto(String tipoProduto) { this.tipoProduto = tipoProduto; }
    
    // O ID (`idProduto`) geralmente não possui um `setter` público
    // porque é um identificador único e, uma vez definido, não deve ser alterado
    // para garantir a integridade dos dados.
}