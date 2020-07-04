package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.controllers.HomeController;

// Habilitando o uso do Spring MVC dentro do projeto
@EnableWebMvc

// Informando ao Spring onde estão os nossos controllers e os DAOs
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class})

public class AppWebConfiguration {

	// Toda a classe gerenciada pelo Spring recebe essa anotação
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
