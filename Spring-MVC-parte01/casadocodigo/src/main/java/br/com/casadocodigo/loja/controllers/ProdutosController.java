package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class ProdutosController {

	@Autowired // Pedimos para o Spring uma instância do objeto que foi anotado
	private ProdutoDAO produtoDao;

	// Esse método informamos onde está a nossa view produtos form
	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/form";
	}

	// Metódo que atenderá à URL casadocodigo/produtos que é justamente o endereço
	// que o formulário está enviando os dados.
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produtos/ok";
	}
}
