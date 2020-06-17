package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		response.sendRedirect("entrada?acao=listaEmpresas");
		
		System.out.println("Removendo empresa");
	}
}
