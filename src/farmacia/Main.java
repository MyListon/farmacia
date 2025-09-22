package farmacia;

import java.util.Scanner;

import farmacia.model.Produto;

public class Main {

	public static void main(String[] args) {
		Farmacia farmacia = new Farmacia();
        Scanner scanner = new Scanner(System.in);
        
        // Adicionando alguns produtos de exemplo
        farmacia.adicionarProduto(new Produto("Dorflex", "Sanofi", 15.99, "ID001", 50, "Medicamento"));
        farmacia.adicionarProduto(new Produto("Protetor Solar FPS 30", "Nivea", 35.50, "ID002", 20, "Higiene"));

        int opcao;
        do {
            System.out.println("\n--- Menu da Farmácia ---");
            System.out.println("1. Ver todos os produtos");
            System.out.println("2. Buscar produto por ID");
            System.out.println("3. Adicionar novo produto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha

            switch (opcao) {
                case 1:
                    farmacia.exibirTodosProdutos();
                    break;
                case 2:
                    System.out.print("Digite o ID do produto: ");
                    String idBusca = scanner.nextLine();
                    farmacia.buscarProdutoPorId(idBusca);
                    break;
                case 3:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Fabricante: ");
                    String fabricante = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Consome a quebra de linha
                    System.out.print("ID do Produto: ");
                    String idProduto = scanner.nextLine();
                    System.out.print("Quantidade em Estoque: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consome a quebra de linha
                    System.out.print("Tipo de Produto: ");
                    String tipo = scanner.nextLine();
                    
                    Produto novoProduto = new Produto(nome, fabricante, preco, idProduto, quantidade, tipo);
                    farmacia.adicionarProduto(novoProduto);
                    break;
                case 4:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}