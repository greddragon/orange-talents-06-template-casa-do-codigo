package br.com.zupacademy.gerson.casadocodigo.controller.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.gerson.casadocodigo.dto.CategoriaDto;
import br.com.zupacademy.gerson.casadocodigo.model.Categoria;
import br.com.zupacademy.gerson.casadocodigo.repository.RepositoryCategoria;

@Component
public class NomeCategoriaDuplicadoValidator implements Validator{
	
	@Autowired
	RepositoryCategoria repositoryCategoria;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CategoriaDto cd = (CategoriaDto) target;
		Optional<Categoria> categoria = repositoryCategoria.findByNome(cd.getNome());
		
		if(categoria.isPresent()) {
			errors.rejectValue("nome", null, "Não pode existir Categorias com o mesmo nome");
		}
		
		
	}

}
