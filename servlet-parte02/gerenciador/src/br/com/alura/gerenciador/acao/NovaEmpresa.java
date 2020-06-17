package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
			throw new ServletException(e);
		}

		// Criando uma empresa utilizando o nome recebido por parâmetro
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(abertura);

		// Usando a classe banco como container para simular um banco de dados
		Banco banco = new Banco();
		banco.adiciona(empresa);

		// Fazendo um redirecionamento
		response.sendRedirect("entrada?acao=listaEmpresas");

		System.out.println("Criando nova empresa");

	}

}
