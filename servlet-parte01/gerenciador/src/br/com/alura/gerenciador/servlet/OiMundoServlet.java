package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Definindo a rota para o Servlet http://localhost:8080/gerenciador/oi
// Para mapear a URL para uma servlet usamos a anotação 
@WebServlet(urlPatterns = "/oi")

// Uma servlet é um objeto Java que podemos chamar a partir de uma requisição HTTP
public class OiMundoServlet extends HttpServlet {

	
	// Sobrescrevendo o método service para que responda com um HTML
	// Método service de uma Servlet é capaz de responder requisições do tipo GET ou
	// do tipo POST
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>oi mundo, parabéns você escreveu seu primeiro servlets</h1>");
		writer.println("<body>");
		writer.println("</html>");
	}

}
