package br.com.zupacademy.gerson.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gerson.casadocodigo.dto.CategoriaDto;
import br.com.zupacademy.gerson.casadocodigo.model.Categoria;
import br.com.zupacademy.gerson.casadocodigo.repository.RepositoryCategoria;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	RepositoryCategoria repositoryCategoria;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaDto request) {
		Categoria categoria = request.toCategoria();
		repositoryCategoria.save(categoria);
		return ResponseEntity.ok().body(request);
	}
}
