package farmacia;

import java.util.InputMismatchException;
import java.util.Scanner;
import farmacia.model.Produto;

/**
 * A classe `Main` é o ponto de entrada principal do programa.
 * Ela gerencia a interação com o usuário, o menu de opções e as chamadas
 * para os métodos da classe `Farmacia`.
 */
public class Main {

    /**
     * O método `main` é o ponto de partida da execução do programa.
     *
     * @param args Argumentos de linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {
        // Cria uma instância da classe Farmacia, que irá gerenciar os produtos.
        Farmacia farmacia = new Farmacia();
        // Cria um objeto Scanner para ler a entrada do usuário no console.
        Scanner scanner = new Scanner(System.in);
        
        // Adiciona alguns produtos iniciais para teste.
        farmacia.adicionarProduto(new Produto("Dorflex", "Sanofi", 15.99, "ID001", 50, "Medicamento"));
        farmacia.adicionarProduto(new Produto("Protetor Solar FPS 30", "Nivea", 35.50, "ID002", 20, "Higiene"));

        int opcao;
        // Loop 'do-while' para exibir o menu e processar as opções até que o usuário escolha sair.
        do {
            System.out.println("\n--- Menu da Farmácia ---");
            System.out.println("1. Ver todos os produtos");
            System.out.println("2. Buscar produto por ID");
            System.out.println("3. Adicionar novo produto");
            System.out.println("4. Remover produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                // Tenta ler a opção do usuário.
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha pendente após a leitura do número.

                // A estrutura 'switch' executa a ação correspondente à opção escolhida.
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
                // Captura a exceção caso o usuário digite algo que não seja um número.
                System.out.println("Erro: A entrada deve ser um número. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer de entrada para evitar um loop infinito de erro.
                opcao = 0; // Define a opção como 0 para que o loop continue.
            }
        } while (opcao != 5);

        // Fecha o Scanner para liberar os recursos do sistema.
        scanner.close();
    }
    
    // --- Métodos Auxiliares ---
    // Esses métodos foram criados para modularizar e organizar o código do `main`.

    /**
     * Exibe a lista de todos os produtos cadastrados na farmácia.
     * @param farmacia A instância da classe Farmacia contendo a lista de produtos.
     */
    private static void exibirTodosProdutos(Farmacia farmacia) {
        // Verifica se a lista de produtos está vazia.
        if (farmacia.getProdutos().isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("--- Lista de Produtos ---");
            // Itera sobre a coleção de valores (objetos Produto) do mapa.
            for (Produto produto : farmacia.getProdutos().values()) {
                produto.exibirInfo();
                System.out.println("--------------------------");
            }
        }
    }

    /**
     * Solicita um ID e busca o produto correspondente na farmácia.
     * @param farmacia A instância da classe Farmacia.
     * @param scanner O objeto Scanner para ler a entrada do usuário.
     */
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

    /**
     * Coleta informações do usuário e adiciona um novo produto à farmácia.
     * @param farmacia A instância da classe Farmacia.
     * @param scanner O objeto Scanner para ler a entrada do usuário.
     */
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
            
            // Cria uma nova instância de Produto com os dados fornecidos.
            Produto novoProduto = new Produto(nome, fabricante, preco, idProduto, quantidade, tipo);
            // Adiciona o novo produto ao estoque da farmácia.
            farmacia.adicionarProduto(novoProduto);
            System.out.println("Produto '" + idProduto + "' adicionado com sucesso!");
        } catch (InputMismatchException e) {
            // Captura a exceção se o preço ou quantidade não forem números.
            System.out.println("Erro: Entrada de preço ou quantidade inválida.");
            scanner.nextLine(); // Limpa o buffer.
        }
    }

    /**
     * Solicita um ID e remove o produto correspondente da farmácia.
     * @param farmacia A instância da classe Farmacia.
     * @param scanner O objeto Scanner para ler a entrada do usuário.
     */
    private static void removerProduto(Farmacia farmacia, Scanner scanner) {
        System.out.print("Digite o ID do produto a ser removido: ");
        String idRemocao = scanner.nextLine();
        // Primeiro, busca o produto para verificar se ele existe.
        Produto produtoRemovido = farmacia.buscarProdutoPorId(idRemocao);
        if (produtoRemovido != null) {
            farmacia.removerProduto(idRemocao);
            System.out.println("Produto '" + idRemocao + "' removido com sucesso!");
        } else {
            System.out.println("Produto com ID '" + idRemocao + "' não encontrado.");
        }
    }
}