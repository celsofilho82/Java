package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaempresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Quando definimos que só vamos receber requisições post nosso servlet passa a
	// trabalhar somente com esse método
	// gerando esse erro no tomcat: HTTP Status 405 – Method Not Allowed
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// O método getParameter(..) sempre retorna uma string e recebe como parâmetro o
		// nome do parâmetro recebido na requisição.
		String nomeEmpresa = request.getParameter("nome");

		PrintWriter writer = response.getWriter();
		writer.println("<html><body><h1>Empresa " + nomeEmpresa + " Cadastrada!<h1></body></html>");

	}

}
