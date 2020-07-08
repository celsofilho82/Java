package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

// Classe responsável por salvar os arquivos enviados no servidor através do formulário
// Anotação @Component informa ao Sprint que a classe é um componente 
@Component
public class FileSaver {

	// Criando um field request para obter o diretório local onde o servidor está rodando
	@Autowired
	private HttpServletRequest request;
	
	// Esse método recebe um diretório path e o arquivos e realiza a transferência
	public String write(String diretorio, MultipartFile file) {
		try {
			String realPath = request.getServletContext().getRealPath("/"+diretorio);
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));
			
			return diretorio + "/" + file.getOriginalFilename();
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
