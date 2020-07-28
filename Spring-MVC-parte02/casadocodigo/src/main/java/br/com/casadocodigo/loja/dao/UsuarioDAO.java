package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

// Classe responsável por manipular os dados dos usuários no banco de dados.

@Repository
public class UsuarioDAO implements UserDetailsService {

	// Definiremos também um atributo privado do tipo EntityManager que chamaremos
	// de manager e o anotaremos com PersistenceContext
	@PersistenceContext
	private EntityManager manager;

	// Método loadUserByUsername que recebe um parâmetro do tipo String que será o email do
	// usuário a ser buscado no banco de dados.
	public UserDetails loadUserByUsername(String email) {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
                .setParameter("email", email).getResultList();

        if (usuarios.isEmpty()) {
            throw new UsernameNotFoundException("O usuário " + email + " não foi encontrado");
        }

        return usuarios.get(0);
    }
}
