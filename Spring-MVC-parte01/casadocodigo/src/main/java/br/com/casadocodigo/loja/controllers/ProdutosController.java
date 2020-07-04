package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
public class ProdutosController {

	@Autowired // Pedimos para o Spring uma instância do objeto que foi anotado
	private ProdutoDAO produtoDao;

	// Esse método informamos onde está a nossa view produtos form
	@RequestMapping("/produtos/form")
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
	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produtos/ok";
	}
}
