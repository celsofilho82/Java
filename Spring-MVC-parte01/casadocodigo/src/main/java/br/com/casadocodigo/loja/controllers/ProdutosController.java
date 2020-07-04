package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller 
@RequestMapping("produtos") // Informando ao Spring que a classe vai responder na rota
public class ProdutosController {

	@Autowired // Pedimos para o Spring uma instância do objeto que foi anotado
	private ProdutoDAO produtoDao;

	// Essa anotação informamos onde está a nossa view produtos form
	@RequestMapping("/form")
	public ModelAndView form() {
		// Quando utilizamos o ModelAndView, além de retornarmos as páginas, temos a
		// possibilidade de enviar objetos de qualquer classe para a página caso seja
		// necessário
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}

	// Metódo que atenderá à URL casadocodigo/produtos que é justamente o endereço
	// que o formulário está enviando os dados.
	// Indicando ao Spring MVC o método de requisição do HTTP
	@RequestMapping(method=RequestMethod.POST)
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produtos/ok";
	}

	// Esse método será responsável por enviar para nossa pagina lista.jsp uma lista
	// de produtos para exibirmos na página
	// Indicando ao Spring MVC o método de requisição do HTTP
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
}
