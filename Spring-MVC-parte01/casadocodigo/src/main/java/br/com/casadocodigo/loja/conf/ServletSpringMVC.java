package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Classe de configuraçao do Spring MVC
public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// Disponibilizando as classes de configurações para o Spring
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class} ;
	}

	@Override
	protected String[] getServletMappings() {
		// Criando o mapeamento para que o Spring responda a rota raiz
		return new String[] { "/" };
	}

}
