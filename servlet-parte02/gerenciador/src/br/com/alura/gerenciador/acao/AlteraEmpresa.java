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

public class AlteraEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// O método getParameter(..) sempre retorna uma string e recebe como parâmetro o
		// nome do parâmetro recebido na requisição.
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");
		String paramId = request.getParameter("id");

		// Realizando um parse para transformar o id que é enviado como string em um
		// integer
		Integer empresaId = Integer.valueOf(paramId);

		// Realizando um parsing da data que recebemos como parâmetro do formulário
		Date abertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			abertura = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		// Instanciando a classe banco de dados
		Banco banco = new Banco();

		// Utilizando o método para buscar a empresa pelo id
		Empresa empresa = banco.buscaEmpresa(empresaId);

		// Atualizando os dados da empresa com as informações recebidas no forumulário
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(abertura);

		// Fazendo um redirecionamento
		response.sendRedirect("entrada?acao=listaEmpresas");
		
		System.out.println("Alterando empresa");
	}

}
