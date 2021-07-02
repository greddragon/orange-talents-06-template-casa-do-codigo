package br.com.zupacademy.gerson.casadocodigo.controller.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gerson.casadocodigo.dto.AutorDto;
import br.com.zupacademy.gerson.casadocodigo.model.Autor;
import br.com.zupacademy.gerson.casadocodigo.repository.RepositoryAutor;

@Component
public class EmailDuplicadoValidator implements Validator {

	@Autowired
	private RepositoryAutor repository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		AutorDto a = (AutorDto) target;

		Optional<Autor> verificaAutor = repository.findByEmail(a.getEmail());
		if (verificaAutor.isPresent()) {
			errors.rejectValue("email", null, "email já cadastrado, não pode haver email iguais. ");
		}

	}

}
