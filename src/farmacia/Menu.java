package farmacia;

import java.util.Scanner;
import farmacia.model.Cosmetico;
import farmacia.model.Medicamento;
import farmacia.model.Produto;
import farmacia.util.Cores;

public class Menu {

    public static void main(String[] args) {

    	Scanner leia = new Scanner(System.in);
        int opcao;

        // Instanciar Objetos das Classes Filhas para demonstração
        System.out.println(Cores.TEXT_CYAN_BOLD + "*****************************************************");
        System.out.println("  Testes da Classe de Herança - Farmácia ");
        System.out.println("*****************************************************" + Cores.TEXT_RESET);

        Medicamento m1 = new Medicamento(1, "Dorflex", 15.99f, 50, "Dipirona Monoidratada");
        m1.visualizar();
        
        Cosmetico c1 = new Cosmetico(2, "Protetor Solar FPS 30", 35.50f, 20, "Todos os tipos");
        c1.visualizar();
        
        while (true) {
            System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("                 Farmácia do Campo                   ");
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
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     " + Cores.TEXT_RESET);
            
            try {
                opcao = leia.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida! Digite um número inteiro.\n" + Cores.TEXT_RESET);
                leia.nextLine(); // Limpa o buffer do scanner
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
                    // Adicione a lógica de cadastro aqui
                    break;
                case 2:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todos os Produtos \n\n");
                    // Adicione a lógica de listagem aqui
                    break;
                case 3:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Buscar por ID Produto\n\n");
                    // Adicione a lógica de busca aqui
                    break;    
                case 4:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados do Produto \n\n");
                    // Adicione a lógica de atualização aqui
                    break;
                case 5:
                    System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar Produto\n\n");
                    // Adicione a lógica de exclusão aqui
                    break;
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
                    break;
            }
        }
    }
}