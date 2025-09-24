package farmacia.model;

public class Cosmetico extends Produto {

    private String tipoPele;

    public Cosmetico(int id, String nome, float preco, int quantidade, String tipoPele) {
        super(id, nome, preco, 2, quantidade); // A categoria 2 é fixa para Cosmético
        this.tipoPele = tipoPele;
    }

    public String getTipoPele() { return tipoPele; }
    public void setTipoPele(String tipoPele) { this.tipoPele = tipoPele; }
    
    @Override
    public void visualizar() {
        super.visualizar(); // Chama o método visualizar da classe pai
        System.out.printf("Tipo de Pele: %s%n", this.tipoPele);
        System.out.println("----------------------------------------");
    }
}