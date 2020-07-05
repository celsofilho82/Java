package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.com.casadocodigo.loja.models.Produto;

// Essa classe tem como objetivo realizar a validação dos dados inseridos no formulário
public class ProdutoValidation implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// Esse método indica que podemos chamar o validador para a nossa classe produto
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Realizando a validação do formulário usando a classe do Spring
		// ValidationUtils
		Produto produto = (Produto) target;
		ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

		if (produto.getPaginas() == null) {
			errors.rejectValue("paginas", "field.required");
		}

	}

}
