package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
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
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("listaEmpresas")) {
			ListaEmpresas listar = new ListaEmpresas();
			listar.executa(request, response);
		}else if(paramAcao.equals("removeEmpresa")) {
			RemoveEmpresa remover = new RemoveEmpresa();
			remover.executa(request, response);
		}else if(paramAcao.equals("mostraEmpresa")) {
			MostraEmpresa mostrar = new MostraEmpresa();
			mostrar.executa(request, response);
			
		}else if(paramAcao.equals("alteraEmpresa")) {
			AlteraEmpresa alterar = new AlteraEmpresa();
			alterar.executa(request, response);
			
		}else if(paramAcao.equals("novaEmpresa")) {
			NovaEmpresa criar = new NovaEmpresa();
			criar.executa(request, response);
		}
		
	}

}
