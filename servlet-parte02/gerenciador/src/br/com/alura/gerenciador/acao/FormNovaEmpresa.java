package br.com.alura.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormNovaEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formNovaEmpresa.jsp";
	}
	
}
