package farmacia.model;

public abstract class Produto {
    
    // Atributos da Super Classe (conforme o diagrama)
    private int id;
    private String nome;
    private float preco;
    private int tipo; // Corresponde à 'categoria' que você usou, mas 'tipo' está no diagrama [cite: 15]

    // Construtor
    public Produto(int id, String nome, float preco, int tipo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }
    
    // Métodos Getters e Setters (conforme o diagrama)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public float getPreco() { return preco; }
    public void setPreco(float preco) { this.preco = preco; }

    public int getTipo() { return tipo; } // Alterado de 'getCategoria' para 'getTipo'
    public void setTipo(int tipo) { this.tipo = tipo; } // Alterado de 'setCategoria' para 'setTipo'

    /**
     * Exibe as informações básicas do Produto.
     * Este método será chamado pelas subclasses.
     */
    public void visualizar() {
        String tipoProduto = "";
        switch (this.tipo) {
            case 1 -> tipoProduto = "Medicamento"; // 1 para Medicamento
            case 2 -> tipoProduto = "Cosmético"; // 2 para Cosmético
        }

        System.out.println("\n----------------------------------------");
        System.out.println("          Dados do Produto            ");
        System.out.println("----------------------------------------");
        System.out.printf("ID: %d%n", this.id);
        System.out.printf("Produto: %s%n", this.nome);
        System.out.printf("Tipo: %s%n", tipoProduto);
        System.out.printf("Preço: R$ %.2f%n", this.preco);
    }
}