package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtendo o parâmetro ID da requisição vindo da página JSP listaEmpresas
		String paramId = request.getParameter("id");

		// Realizando um parse para transformar o id que é enviado como string em um
		// integer
		Integer empresaId = Integer.valueOf(paramId);

		// Instanciando a classe banco de dados
		Banco banco = new Banco();

		// Utilizando o método para buscar a empresa pelo id
		Empresa empresa = banco.buscaEmpresa(empresaId);

		// Enviando os dados para a página JSP onde existe o formulário para alterar os
		// dados da empresa
		request.setAttribute("empresa", empresa);
		
		System.out.println("Exibindo empresa");
		return "forward:formAlteraEmpresa.jsp";
	}
}
