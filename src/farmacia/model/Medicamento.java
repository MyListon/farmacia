package farmacia.model;

public class Medicamento extends Produto {
    
    private String principioAtivo;

    public Medicamento(int id, String nome, float preco, int quantidade, String principioAtivo) {
        super(id, nome, preco, 1, quantidade); // A categoria 1 é fixa para Medicamento
        this.principioAtivo = principioAtivo;
    }

    public String getPrincipioAtivo() { return principioAtivo; }
    public void setPrincipioAtivo(String principioAtivo) { this.principioAtivo = principioAtivo; }
    
    @Override
    public void visualizar() {
        super.visualizar(); // Chama o método visualizar da classe pai
        System.out.printf("Princípio Ativo: %s%n", this.principioAtivo);
        System.out.println("----------------------------------------");
    }
}