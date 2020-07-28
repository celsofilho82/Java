package br.com.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.casadocodigo.loja.dao.UsuarioDAO;

// Essa classe armazena  as configurações de segurança, iremos anotá-la com EnableWebSecurity
// Spring através da classe com esta anotação já configura alguns detalhes de segurança de forma automática.

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDAO usuarioDao;

	// Sobrescrevendo o método configure que que em sua implementação padrão,
	// bloqueia e redireciona todas as requisições não autenticadas.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers("/carrinho/**").permitAll()
				.antMatchers("/resources/**").permitAll().antMatchers("/pagamento/**").permitAll()
				.antMatchers("/produtos/form").hasRole("ADMIN").antMatchers(HttpMethod.POST, "/produtos")
				.hasRole("ADMIN").antMatchers(HttpMethod.GET, "/produtos").hasRole("ADMIN").antMatchers("/produtos/**")
				.permitAll().antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	// Sobrescrevendo o método configure na classe SecurityConfiguration, que recebe
	// um objeto do tipo AuthenticationManagerBuilder chamado de auth e usar o
	// método userDetailsService passando para este método um objeto do tipo
	// UsuarioDAO
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao).passwordEncoder(new BCryptPasswordEncoder());
	}

}
