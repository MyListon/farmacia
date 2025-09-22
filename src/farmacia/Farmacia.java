package farmacia;

import java.util.HashMap;

import farmacia.model.Produto;

public class Farmacia {
	// Usamos um HashMap para armazenar os produtos.
    // A chave é o ID do produto e o valor é o objeto Produto.
    private HashMap<String, Produto> produtos;

    public Farmacia() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getIdProduto(), produto);
        System.out.println("Produto '" + produto.getIdProduto() + "' adicionado com sucesso!");
    }

    public void exibirTodosProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("--- Lista de Produtos ---");
            for (Produto produto : produtos.values()) {
                produto.exibirInfo();
                System.out.println("--------------------------");
            }
        }
    }

    public void buscarProdutoPorId(String id) {
        Produto produto = produtos.get(id);
        if (produto != null) {
            produto.exibirInfo();
        } else {
            System.out.println("Produto com ID '" + id + "' não encontrado.");
        }
    }
}
