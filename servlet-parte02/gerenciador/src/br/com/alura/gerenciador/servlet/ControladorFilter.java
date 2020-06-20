package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class ControladorFilter
 */
@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// place your code here

		String paramAcao = request.getParameter("acao");

		String paginaJSP;

		try {
			String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
			Class classe = Class.forName(nomeDaClasse);
			Object obj = (Acao) classe.newInstance();
			Acao acao = (Acao) obj;
			paginaJSP = acao.executa((HttpServletRequest) request, (HttpServletResponse) response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
				| ServletException e) {
			throw new ServletException(e);
		}

		String[] acaoEndereco = paginaJSP.split(":");

		if (acaoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + acaoEndereco[1]);
			rd.forward(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect(acaoEndereco[1]);
		}

		// pass the request along the filter chain

	}

}
