package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveEmpresaServlet
 */
@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
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
		
		// Removendo a empresa passando como parâmetro o id
		banco.removeEmpresa(empresaId);
		
		// Após a remoção, redirecionando para a página de lista empresas
		response.sendRedirect("listaEmpresas");
		
	}

}
