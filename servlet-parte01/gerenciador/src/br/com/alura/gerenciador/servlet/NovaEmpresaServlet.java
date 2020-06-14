package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
	// trabalhar somente com esse método gerando esse erro no tomcat: HTTP Status
	// 405 – Method Not Allowed
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// O método getParameter(..) sempre retorna uma string e recebe como parâmetro o
		// nome do parâmetro recebido na requisição.
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");
		
		// Realizando um parsing da data que recebemos como parâmetro do formulário
		Date abertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			abertura = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e) ;
		}

		// Criando uma empresa utilizando o nome recebido por parâmetro
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(abertura);

		// Usando a classe banco como container para simular um banco de dados
		Banco banco = new Banco();
		banco.adiciona(empresa);

		PrintWriter writer = response.getWriter();
		writer.println("<html><body><h1>Empresa " + nomeEmpresa + " Cadastrada!<h1></body></html>");
		
		// Chamando um página JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome());
		rd.forward(request, response);
	}

}
