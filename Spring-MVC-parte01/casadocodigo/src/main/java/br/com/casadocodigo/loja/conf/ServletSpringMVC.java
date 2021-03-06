package br.com.casadocodigo.loja.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
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
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
	}
	
//	@Override
//	protected Filter[] getServletFilters() {
//		Criando um filtro no Spring para tratar da codificação da página
//		Neste caso eu não estou utilizando esse método pois não tenho problemas
//	
//		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//		encodingFilter.setEncoding("UTF-8");
//		return new Filter[] {encodingFilter};
//	}

}
