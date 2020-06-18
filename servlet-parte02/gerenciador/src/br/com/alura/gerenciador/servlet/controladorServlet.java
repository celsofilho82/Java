package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.FormNovaEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class controladorServlet
 */
@WebServlet("/entrada")
public class controladorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaJSP;
		
		try {
			String paramAcao = request.getParameter("acao");
			String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
			Class classe = Class.forName(nomeDaClasse);
			Object obj = (Acao) classe.newInstance();
			Acao acao = (Acao) obj;
			paginaJSP = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
				| ServletException e) {
			throw new ServletException(e);
		}
		
		String[] acaoEndereco = paginaJSP.split(":");
		
		if(acaoEndereco[0].equals("forward")){
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + acaoEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(acaoEndereco[1]);
		}
		
		
		// Refatoração da classe 
		
//		if(paramAcao.equals("listaEmpresas")) {
//			ListaEmpresas listar = new ListaEmpresas();
//			paginaJSP = listar.executa(request, response);
//		}else if(paramAcao.equals("removeEmpresa")) {
//			RemoveEmpresa remover = new RemoveEmpresa();
//			paginaJSP = remover.executa(request, response);
//		}else if(paramAcao.equals("mostraEmpresa")) {
//			MostraEmpresa mostrar = new MostraEmpresa();
//			paginaJSP = mostrar.executa(request, response);
//			
//		}else if(paramAcao.equals("alteraEmpresa")) {
//			AlteraEmpresa alterar = new AlteraEmpresa();
//			paginaJSP = alterar.executa(request, response);
//			
//		}else if(paramAcao.equals("novaEmpresa")) {
//			NovaEmpresa criar = new NovaEmpresa();
//			paginaJSP = criar.executa(request, response);
//		}else if(paramAcao.equals("formNovaEmpresa")) {
//			FormNovaEmpresa form = new FormNovaEmpresa();
//			paginaJSP = form.executa(request, response);
//		}
		
		
	}

}
