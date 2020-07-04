package br.com.casadocodigo.loja.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

// Classe responsável por fazer a comunicação com o banco de dados,

@Repository // Fazendo com que Spring conheça classe resposável acesso a dados
@Transactional // Spring ativa o gerenciamento de transações e já reconhece o TransactionManager
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

}
