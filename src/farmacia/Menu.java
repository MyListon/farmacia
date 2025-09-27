package farmacia;

import java.util.InputMismatchException;
import java.util.Scanner;

import farmacia.controller.ProdutoController;
import farmacia.model.Cosmetico;
import farmacia.model.Medicamento;
import farmacia.model.Produto;
import farmacia.util.Cores; // Presumo que a classe Cores existe

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	private static final ProdutoController produtoController = new ProdutoController();
	
    public static void main(String[] args) {
        
        // Dados de exemplo, usando o novo construtor (sem quantidade)
        produtoController.criarProduto(new Medicamento(produtoController.gerarId(), "Dipirona", 5.99f, "Dipirona Monoidratada"));
        produtoController.criarProduto(new Cosmetico(produtoController.gerarId(), "Protetor Solar FPS 30", 35.00f, "Toque Seco"));
        
        int opcao;
        
        // Seu Menu principal... (Mantido como você escreveu, focando no switch)
        while (true) {
            System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                 Farmácia da Ada                     ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("             1 - Cadastrar Produto                   ");
            System.out.println("             2 - Listar todos os produtos            ");
            System.out.println("             3 - Buscar por ID Produto               ");
            System.out.println("             4 - Atualizar Dados do Produto          ");
            System.out.println("             5 - Apagar Produto                      ");
            System.out.println("             0 - Sair                                ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.print("Entre com a opção desejada:                          \n" + Cores.TEXT_RESET);
            
            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida! Digite um número inteiro.\n" + Cores.TEXT_RESET);
                leia.nextLine(); 
                continue;
            }

            if (opcao == 0) {
                System.out.println(Cores.TEXT_WHITE_BOLD + "\nFarmácia do Campo - O seu bem-estar em primeiro lugar!");
                leia.close();
                System.exit(0);
            }
            
            switch (opcao) {
                case 1:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Cadastrar Produto \n\n");
                    cadastrarProduto();
                    keyPress();
                    break;
                case 2:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todos os Produtos \n\n");
                    produtoController.listarTodos();
                    keyPress();
                    break;
                case 3:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Buscar por ID Produto\n\n");
                    consultarProdutoPorId();
                    keyPress();
                    break;    
                case 4:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados do Produto \n\n");
                    atualizarProduto();
                    keyPress();
                    break;
                case 5:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar Produto\n\n");
                    deletarProduto();
                    keyPress();
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
                    keyPress();
                    break;
            }
        }
    }
    
    // Método auxiliar para pausar a execução
    public static void keyPress() {
		try {
		    System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		    leia.nextLine(); 
		    leia.nextLine();
		} catch (Exception e) {
		    // Ignora a exceção se houver falha ao ler o Enter
		}
    }
    
    // --- Implementação dos Métodos CRUD ---
    
	private static void cadastrarProduto() {
		int tipo = 0;
		String nome;
		float preco;
		String detalhe; // generico ou fragancia
		
		System.out.println("Selecione o Tipo de Produto:");
		System.out.println("1 - Medicamento");
		System.out.println("2 - Cosmético");
		System.out.print("Opção: ");
		tipo = leia.nextInt();
		leia.nextLine(); // Consome a nova linha
		
		if (tipo < 1 || tipo > 2) {
			System.out.println(Cores.TEXT_RED_BOLD + "Tipo de Produto inválido!" + Cores.TEXT_RESET);
			return;
		}

		System.out.print("Digite o Nome do Produto: ");
		nome = leia.nextLine();

		System.out.print("Digite o Preço do Produto: ");
		preco = leia.nextFloat();
		leia.nextLine(); // Consome a nova linha após o float
		
		int novoId = produtoController.gerarId();

		switch (tipo) {
		case 1 -> {
			System.out.print("Digite o Princípio Ativo (Genérico): ");
			detalhe = leia.nextLine();
			produtoController.criarProduto(new Medicamento(novoId, nome, preco, detalhe));
		}
		case 2 -> {
			System.out.print("Digite a Fragrância: ");
			detalhe = leia.nextLine();
			produtoController.criarProduto(new Cosmetico(novoId, nome, preco, detalhe));
		}
		}
	}

	private static void consultarProdutoPorId() {
		System.out.print("Digite o ID do Produto: ");
		int id = leia.nextInt();
		leia.nextLine(); 
		
		produtoController.consultarPorId(id);
	}
	
	private static void deletarProduto() {
		System.out.print("Digite o ID do Produto para exclusão: ");
		int id = leia.nextInt();
		leia.nextLine(); 

		Produto produto = produtoController.buscarNaCollection(id);
		
		if(produto != null) {
			System.out.print("\nTem certeza que deseja excluir o produto " + produto.getNome() + "? (S/N): ");
			String confirmacao = leia.nextLine();
			
			if(confirmacao.equalsIgnoreCase("S")) {
				produtoController.deletarProduto(id);
			} else {
				System.out.println("\nOperação cancelada!");
			}
			
		} else {
			System.out.printf("\nO Produto de ID %d não foi encontrado!", id);
		}
	}
	
	private static void atualizarProduto() {
		System.out.print("Digite o ID do Produto para atualização: ");
		int id = leia.nextInt();
		leia.nextLine();
 
		Produto produto = produtoController.buscarNaCollection(id);
 
		if (produto != null) {
			
			String nomeAtual = produto.getNome();
			float precoAtual = produto.getPreco();
			int tipo = produto.getTipo();
			
			System.out.printf("Nome atual: %s\nNovo Nome (ENTER para manter): ", nomeAtual);
			String novoNome = leia.nextLine();
			novoNome = novoNome.isEmpty() ? nomeAtual : novoNome;
				
			System.out.printf("Preço atual: %.2f\nNovo Preço (ENTER para manter): ", precoAtual);
			String entradaPreco = leia.nextLine();
			float novoPreco = entradaPreco.isEmpty() ? precoAtual : Float.parseFloat(entradaPreco);
			
			
			switch (tipo) {
			case 1 -> { // Medicamento
				String genericoAtual = ((Medicamento) produto).getGenerico();
				
				System.out.printf("Princípio Ativo atual: %s\nNovo Princípio Ativo (ENTER para manter): ", genericoAtual);
				String novoGenerico = leia.nextLine();
				novoGenerico = novoGenerico.isEmpty() ? genericoAtual : novoGenerico;
				
				// Cria novo objeto com dados atualizados e o ID original
				produtoController.atualizarProduto(new Medicamento(id, novoNome, novoPreco, novoGenerico));
			}
			case 2 -> { // Cosmético
				String fraganciaAtual = ((Cosmetico) produto).getFragancia();
				
				System.out.printf("Fragrância atual: %s\nNova Fragrância (ENTER para manter): ", fraganciaAtual);
				String novaFragancia = leia.nextLine();
				novaFragancia = novaFragancia.isEmpty() ? fraganciaAtual : novaFragancia;
				
				// Cria novo objeto com dados atualizados e o ID original
				produtoController.atualizarProduto(new Cosmetico(id, novoNome, novoPreco, novaFragancia));
			}
			}
			
		} else {
			System.out.printf("\nO Produto de ID %d não foi encontrado!%n", id);
		}
 
	}
}