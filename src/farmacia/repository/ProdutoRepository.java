package farmacia.repository;

import farmacia.model.Produto;

public interface ProdutoRepository {
	
	// Métodos do CRUD (conforme solicitado)
	
	public void criarProduto(Produto produto); 
	public void listarTodos();
	public void consultarPorId(int id);
	public void atualizarProduto(Produto produto);
	public void deletarProduto(int id);
}