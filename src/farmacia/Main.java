package farmacia;

import java.util.InputMismatchException;
import java.util.Scanner;
import farmacia.model.Produto;

public class Main {

    public static void main(String[] args) {
        Farmacia farmacia = new Farmacia();
        Scanner scanner = new Scanner(System.in);
        
        farmacia.adicionarProduto(new Produto("Dorflex", "Sanofi", 15.99, "ID001", 50, "Medicamento"));
        farmacia.adicionarProduto(new Produto("Protetor Solar FPS 30", "Nivea", 35.50, "ID002", 20, "Higiene"));

        int opcao;
        do {
            System.out.println("\n--- Menu da Farmácia ---");
            System.out.println("1. Ver todos os produtos");
            System.out.println("2. Buscar produto por ID");
            System.out.println("3. Adicionar novo produto");
            System.out.println("4. Remover produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha

                switch (opcao) {
                    case 1:
                        exibirTodosProdutos(farmacia);
                        break;
                    case 2:
                        buscarProdutoPorId(farmacia, scanner);
                        break;
                    case 3:
                        adicionarNovoProduto(farmacia, scanner);
                        break;
                    case 4:
                        removerProduto(farmacia, scanner);
                        break;
                    case 5:
                        System.out.println("Saindo do sistema. Até mais!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: A entrada deve ser um número. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada para evitar loop infinito
                opcao = 0; // Define a opção como 0 para continuar o loop
            }
        } while (opcao != 5);

        scanner.close();
    }
    
    // Métodos auxiliares para organizar o código
    private static void exibirTodosProdutos(Farmacia farmacia) {
        if (farmacia.getProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("--- Lista de Produtos ---");
            for (Produto produto : farmacia.getProdutos().values()) {
                produto.exibirInfo();
                System.out.println("--------------------------");
            }
        }
    }

    private static void buscarProdutoPorId(Farmacia farmacia, Scanner scanner) {
        System.out.print("Digite o ID do produto: ");
        String idBusca = scanner.nextLine();
        Produto produtoEncontrado = farmacia.buscarProdutoPorId(idBusca);
        if (produtoEncontrado != null) {
            produtoEncontrado.exibirInfo();
        } else {
            System.out.println("Produto com ID '" + idBusca + "' não encontrado.");
        }
    }

    private static void adicionarNovoProduto(Farmacia farmacia, Scanner scanner) {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Fabricante: ");
            String fabricante = scanner.nextLine();
            System.out.print("Preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("ID do Produto: ");
            String idProduto = scanner.nextLine();
            System.out.print("Quantidade em Estoque: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Tipo de Produto: ");
            String tipo = scanner.nextLine();
            
            Produto novoProduto = new Produto(nome, fabricante, preco, idProduto, quantidade, tipo);
            farmacia.adicionarProduto(novoProduto);
            System.out.println("Produto '" + idProduto + "' adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada de preço ou quantidade inválida.");
            scanner.nextLine();
        }
    }

    private static void removerProduto(Farmacia farmacia, Scanner scanner) {
        System.out.print("Digite o ID do produto a ser removido: ");
        String idRemocao = scanner.nextLine();
        Produto produtoRemovido = farmacia.buscarProdutoPorId(idRemocao);
        if (produtoRemovido != null) {
            farmacia.removerProduto(idRemocao);
            System.out.println("Produto '" + idRemocao + "' removido com sucesso!");
        } else {
            System.out.println("Produto com ID '" + idRemocao + "' não encontrado.");
        }
    }
}