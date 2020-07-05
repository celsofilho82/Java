package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.controllers.HomeController;

// Habilitando o uso do Spring MVC dentro do projeto
@EnableWebMvc

// Informando ao Spring onde estão os nossos controllers e os DAOs
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDAO.class })

public class AppWebConfiguration {

	// Toda a classe gerenciada pelo Spring recebe essa anotação
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	// Esse método vai informar ao Spring qual é o arquivo de messagens que ele deve
	// utilizar para informar ao usuario na validação de erros do formulário
	// O local do arquivo: src/main/webapp/WEB-INF/message.properties
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
	

}
