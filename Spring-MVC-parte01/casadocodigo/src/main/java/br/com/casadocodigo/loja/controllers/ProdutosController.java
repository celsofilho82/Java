package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos") // Informando ao Spring que a classe vai responder na rota
public class ProdutosController {

	// Método utilizado para fazer o binding com a classe de validação do nosso
	// produto usando a anotação @InitBinder
	// Esse método recebe um objeto WebDataBinder e dentro desse objeto passamos o
	// nosso validador
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}

	// Pedimos para o Spring uma instância do objeto ProdutoDAO
	@Autowired
	private ProdutoDAO produtoDao;

	@Autowired
	private FileSaver fileSaver;

	// Essa anotação informamos onde está a nossa view produtos form
	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
		// Quando utilizamos o ModelAndView, além de retornarmos as páginas, temos a
		// possibilidade de enviar objetos de qualquer classe para a página caso seja
		// necessário
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
	}

	// Metódo responsável por receber os dados da pagina produtos/form, inserir o
	// produto no banco e redireciona o usuário para a página de listar produtos
	// Usando a anotação @Valid para Spring validar o produto
	// O método passsa a receber um arquivo de sumário no form objeto MultipartFile
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result,
			RedirectAttributes redirectAttributes) {

		// Classe responsável por salvar os arquivos
		String path = fileSaver.write("arquivos-sumario", sumario);
		produto.setSumarioPath(path);

		// Verificando erro de validação redirecionado para o form
		if (result.hasErrors()) {
			return form(produto);
		}

		produtoDao.gravar(produto);
		ModelAndView modelAndView = new ModelAndView("redirect:produtos");
		// Flash Scoped adicionamos um objeto que devemos enviar de um request para o
		// outro
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!!");
		return modelAndView;
	}

	// Esse método será responsável por enviar para nossa pagina lista.jsp uma lista
	// de produtos para exibirmos na página
	// Indicando ao Spring MVC o método de requisição do HTTP
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}

	// Esse método será responsável por mostrar os detalhes do produto
	// {id} e (@PathVariable("id") informa ao Spring a utilização de url amigável
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDao.find(id);
		modelAndView.addObject("produto", produto);
		return modelAndView;
	}
}
