package farmacia.model;

public class Cosmetico extends Produto {

    private String fragancia; // Atributo '-fragancia: String' [cite: 32]

    public Cosmetico(int id, String nome, float preco, String fragancia) {
        super(id, nome, preco, 2); // Categoria/Tipo 2 é fixo para Cosmético
        this.fragancia = fragancia;
    }

    // Getters e Setters (conforme o diagrama) [cite: 33, 34]
    public String getFragancia() { return fragancia; }
    public void setFragancia(String fragancia) { this.fragancia = fragancia; }
    
    @Override
    public void visualizar() { // Implementa o método visualizar() [cite: 34]
        super.visualizar(); 
        System.out.printf("Fragrância: %s%n", this.fragancia);
        System.out.println("----------------------------------------");
    }
}