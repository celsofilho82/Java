package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		// Podemos implementar o logout de 2 formas:
		// Removendo o atributo usuário logado da sessão
		// sessao.removeAttribute("usuarioLogado");
		
		// Invalidando a sessão com o método invalidate()
		// removendo o cookie
		sessao.invalidate();
		
		
		return "redirect:entrada?acao=LoginForm";
	}

}
