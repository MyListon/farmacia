package farmaciaRepository;

import java.util.HashMap;
import java.util.Scanner;
import farmacia.model.Produto;

// O padrão Repository centraliza a lógica de acesso e manipulação dos dados.
public class FarmaciaRepository {
    
    // Usamos um HashMap para armazenar os produtos. A chave é o ID (String) e o valor é o objeto Produto.
    // O HashMap permite buscas e remoções muito rápidas pelo ID.
    private HashMap<String, Produto> produtos = new HashMap<>();

    // Este método é usado internamente para adicionar um produto ao HashMap.
    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getIdProduto(), produto);
    }
    
    // Métodos públicos que a classe Menu irá chamar para realizar as operações.
    
    // 1. Método para cadastrar um novo produto, recebendo o Scanner como parâmetro.
    public void cadastrar(Scanner scanner) {
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
        
        // Cria um novo objeto Produto com os dados inseridos.
        Produto novoProduto = new Produto(nome, fabricante, preco, idProduto, quantidade, tipo);
        adicionarProduto(novoProduto); // Chama o método privado para adicionar o produto.
        System.out.println("\nProduto '" + idProduto + "' adicionado com sucesso!");
    }
    
    // 2. Método para listar todos os produtos.
    public void listarTodos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            // Percorre todos os valores (objetos Produto) do HashMap.
            for (Produto produto : produtos.values()) {
                produto.exibirInfo();
                System.out.println("--------------------------");
            }
        }
    }
    
    // 3. Método para buscar um produto pelo ID.
    public void buscarPorId(Scanner scanner) {
        System.out.print("Digite o ID do produto: ");
        String idBusca = scanner.nextLine();
        Produto produto = produtos.get(idBusca); // Busca o produto usando o ID como chave.
        
        if (produto != null) {
            // Se o produto for encontrado (não é nulo), exibe suas informações.
            produto.exibirInfo();
        } else {
            // Caso contrário, exibe uma mensagem de erro.
            System.out.println("\nProduto com ID '" + idBusca + "' não encontrado.");
        }
    }
    
    // 4. Método para atualizar os dados de um produto.
    public void atualizar(Scanner scanner) {
        System.out.print("Digite o ID do produto que deseja atualizar: ");
        String idAtualizacao = scanner.nextLine();
        Produto produto = produtos.get(idAtualizacao);
        
        if (produto != null) {
            // Se o produto existir, pede os novos dados e atualiza o objeto.
            System.out.print("Novo nome (" + produto.getNome() + "): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) { // Só atualiza se o novo nome não for vazio.
                produto.setNome(novoNome);
            }
            
            System.out.print("Novo preço (" + produto.getPreco() + "): ");
            double novoPreco = scanner.nextDouble();
            if (novoPreco > 0) { // Só atualiza se o novo preço for válido.
                produto.setPreco(novoPreco);
            }
            scanner.nextLine();
            
            System.out.println("\nProduto atualizado com sucesso!");
        } else {
            System.out.println("\nProduto com ID '" + idAtualizacao + "' não encontrado.");
        }
    }
    
    // 5. Método para remover um produto pelo ID.
    public void deletar(Scanner scanner) {
        System.out.print("Digite o ID do produto que deseja remover: ");
        String idRemocao = scanner.nextLine();
        
        // O método containsKey() verifica se a chave (ID) existe no HashMap.
        if (produtos.containsKey(idRemocao)) {
            produtos.remove(idRemocao); // Remove a entrada do HashMap.
            System.out.println("\nProduto '" + idRemocao + "' removido com sucesso!");
        } else {
            System.out.println("\nProduto com ID '" + idRemocao + "' não encontrado.");
        }
    }
}