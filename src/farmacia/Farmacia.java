package farmacia;

import java.util.HashMap;
import farmacia.model.Produto;

/**
 * A classe `Farmacia` atua como o sistema de gerenciamento central para os produtos.
 * Ela utiliza um `HashMap` para armazenar os produtos, o que permite buscas e
 * manipulações rápidas usando o ID do produto como chave.
 */
public class Farmacia {
    // Declara um HashMap privado para armazenar os objetos `Produto`.
    // A chave do mapa será o ID do produto (String) e o valor será o objeto `Produto` correspondente.
    private HashMap<String, Produto> produtos;

    /**
     * Construtor da classe `Farmacia`.
     * Inicializa o HashMap quando um novo objeto `Farmacia` é criado.
     */
    public Farmacia() {
        this.produtos = new HashMap<>();
    }

    /**
     * Adiciona um novo produto ao estoque da farmácia.
     * O ID do produto é usado como a chave no HashMap para garantir que cada produto
     * seja único e facilmente acessível.
     *
     * @param produto O objeto `Produto` a ser adicionado.
     */
    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getIdProduto(), produto);
    }
    
    /**
     * Busca um produto específico no estoque usando seu ID.
     * A busca em um HashMap é muito eficiente, pois o ID leva diretamente ao objeto.
     *
     * @param id O ID do produto a ser buscado.
     * @return O objeto `Produto` se encontrado, ou `null` caso contrário.
     */
    public Produto buscarProdutoPorId(String id) {
        return produtos.get(id);
    }

    /**
     * Remove um produto do estoque com base em seu ID.
     *
     * @param id O ID do produto a ser removido.
     */
    public void removerProduto(String id) {
        produtos.remove(id);
    }

    /**
     * Retorna o HashMap contendo todos os produtos.
     * Isso permite que outras classes acessem a coleção de produtos para, por exemplo,
     * iterar sobre eles ou obter a lista completa.
     *
     * @return O HashMap de produtos.
     */
    public HashMap<String, Produto> getProdutos() {
        return produtos;
    }
}