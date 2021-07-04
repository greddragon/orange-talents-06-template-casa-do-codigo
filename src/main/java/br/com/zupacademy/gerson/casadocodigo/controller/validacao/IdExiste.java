package br.com.zupacademy.gerson.casadocodigo.controller.validacao;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class IdExiste implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
