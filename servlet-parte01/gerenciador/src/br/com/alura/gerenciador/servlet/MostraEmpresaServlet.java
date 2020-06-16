package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);
		
	}

}
