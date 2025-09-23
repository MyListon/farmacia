package farmaciaRepository;

import java.util.InputMismatchException; // Importa a classe para tratamento de exceções de entrada
import java.util.Scanner; // Importa a classe para ler a entrada do usuário
import farmacia.model.Produto; // Importa a classe do modelo de dados

public class Menu {

    public static void main(String[] args) {
        
        Scanner leia = new Scanner(System.in);
        // Cria uma instância da classe FarmaciaRepository para gerenciar os produtos.
        FarmaciaRepository farmacia = new FarmaciaRepository();

        // Adiciona alguns produtos iniciais para demonstração.
        farmacia.adicionarProduto(new Produto("Dorflex", "Sanofi", 15.99, "ID001", 50, "Medicamento"));
        farmacia.adicionarProduto(new Produto("Protetor Solar FPS 30", "Nivea", 35.50, "ID002", 20, "Higiene"));

        int opcao;

        // Loop principal que mantém o menu em execução.
        while (true) {
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                 FARMÁCIA GENERATION                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("             1 - Adicionar Produto                   ");
            System.out.println("             2 - Listar todos os Produtos            ");
            System.out.println("             3 - Buscar Produto por ID               ");
            System.out.println("             4 - Atualizar Dados do Produto          ");
            System.out.println("             5 - Remover Produto                     ");
            System.out.println("             6 - Sair                                ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.print("Entre com a opção desejada: ");
            
            try {
                // Tenta ler a opção do usuário.
                opcao = leia.nextInt();
                leia.nextLine(); // Consome a quebra de linha deixada pelo nextInt().

                // Verifica se o usuário quer sair da aplicação.
                if (opcao == 6) {
                    System.out.println("\nFarmácia Generation - O seu bem-estar em primeiro lugar!");
                    sobre(); // Chama o método para exibir a mensagem de "sobre".
                    leia.close(); // Fecha o Scanner para liberar recursos.
                    System.exit(0); // Encerra o programa.
                }

                // Usa o switch-case para executar a ação correspondente à opção escolhida.
                switch (opcao) {
                    case 1:
                        System.out.println("Adicionar Produto\n\n");
                        farmacia.cadastrar(leia); // Chama o método de cadastro na classe de lógica.
                        break;
                    case 2:
                        System.out.println("Listar todos os Produtos\n\n");
                        farmacia.listarTodos(); // Chama o método para listar.
                        break;
                    case 3:
                        System.out.println("Buscar Produto por ID\n\n");
                        farmacia.buscarPorId(leia); // Chama o método para buscar.
                        break;
                    case 4:
                        System.out.println("Atualizar Dados do Produto\n\n");
                        farmacia.atualizar(leia); // Chama o método para atualizar.
                        break;
                    case 5:
                        System.out.println("Remover Produto\n\n");
                        farmacia.deletar(leia); // Chama o método para remover.
                        break;
                    default:
                        System.out.println("\nOpção Inválida!\n");
                        break;
                }
            } catch (InputMismatchException e) {
                // Captura a exceção se o usuário digitar algo que não seja um número.
                System.out.println("\nEntrada inválida. Por favor, digite um número.\n");
                leia.nextLine(); // Limpa o buffer do scanner para evitar loop infinito.
                opcao = 0; // Define a opção como 0 para que o loop continue.
            }
        }
    }

    // Método estático que exibe informações sobre o desenvolvedor.
    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Geração Brasil");
        System.out.println("generation@generation.org");
        System.out.println("github.com/conteudoGeneration");
        System.out.println("*********************************************************");
    }
}