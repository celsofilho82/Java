package br.com.casadocodigo.loja.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

// Classe responsável por fazer a comunicação com o banco de dados,

@Repository // Fazendo com que Spring conheça classe resposável acesso a dados
@Transactional // Spring ativa o gerenciamento de transações e já reconhece o
				// TransactionManager
public class ProdutoDAO {

	// Solicitando ao Spring que crie um EntityManager
	// Já que o EntityManager trata-se de um recurso persistente, utilize a anotação
	// @PersistenceContext para que ele seja injetável:
	@PersistenceContext
	private EntityManager manager;

	// Método que recebe um produto como parâmetro, e então, a partir do atributo do
	// tipo EntityManager, persista um objeto a partir do método persist()
	public void gravar(Produto produto) {
		manager.persist(produto);
	}

	// Método responsável por obter uma lista de produtos cadastrados no banco de
	// dados
	public List<Produto> listar() {
		return manager.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	// Método responsável por obter um produto no banco de dados pelo ID
	// Realizando uma Query planejada para trazer o produto e o preço
	public Produto find(Integer id) {
		return manager.createQuery("select distinct(p) from Produto p join fetch p.precos where p.id = :id",
				Produto.class).setParameter("id", id).getSingleResult();
	}

}
