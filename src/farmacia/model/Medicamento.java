package farmacia.model;

public class Medicamento extends Produto {
    
    private String generico; // Atributo '-generico: String' [cite: 27]

    public Medicamento(int id, String nome, float preco, String generico) {
        super(id, nome, preco, 1); // Categoria/Tipo 1 é fixo para Medicamento
        this.generico = generico;
    }

    // Getters e Setters (conforme o diagrama) [cite: 28, 29]
    public String getGenerico() { return generico; }
    public void setGenerico(String generico) { this.generico = generico; }
    
    @Override
    public void visualizar() { // Implementa o método visualizar() [cite: 30]
        super.visualizar(); 
        System.out.printf("Princípio Ativo (Genérico): %s%n", this.generico);
        System.out.println("----------------------------------------");
    }
}