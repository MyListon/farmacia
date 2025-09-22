package farmacia;

import java.util.HashMap;
import farmacia.model.Produto;

public class Farmacia {
    private HashMap<String, Produto> produtos;

    public Farmacia() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getIdProduto(), produto);
    }
    
    public Produto buscarProdutoPorId(String id) {
        return produtos.get(id);
    }

    public void removerProduto(String id) {
        produtos.remove(id);
    }

    public HashMap<String, Produto> getProdutos() {
        return produtos;
    }
}