package farmacia.model;

public class Produto {
    
    // Atributos da classe
    private int id;
    private String nome;
    private float preco;
    private int categoria;
    private int quantidade;

    // Construtor
    public Produto(int id, String nome, float preco, int categoria, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    
    // Métodos Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public float getPreco() { return preco; }
    public void setPreco(float preco) { this.preco = preco; }

    public int getCategoria() { return categoria; }
    public void setCategoria(int categoria) { this.categoria = categoria; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    
    // Método para simular a retirada de estoque
    public boolean total(int quantidadeRetirada) {
        if (this.quantidade < quantidadeRetirada) {
            System.out.println("\nQuantidade Insuficiente!");
            return false;
        }
        this.quantidade -= quantidadeRetirada;
        return true;
    }

    public void visualizar() {
        String tipoCategoria = "";
        switch (this.categoria) {
            case 1 -> tipoCategoria = "Medicamento";
            case 2 -> tipoCategoria = "Cosmético";
            default -> tipoCategoria = "Desconhecido";
        }

        System.out.println("----------------------------------------");
        System.out.printf("ID: %d%n", this.id);
        System.out.printf("Produto: %s%n", this.nome);
        System.out.printf("Preço: R$ %.2f%n", this.preco);
        System.out.printf("Categoria: %s%n", tipoCategoria);
        System.out.printf("Quantidade em estoque: %d%n", this.quantidade);
    }
}