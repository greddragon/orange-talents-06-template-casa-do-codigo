package br.com.zupacademy.gerson.casadocodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gerson.casadocodigo.dto.AutorDto;
import br.com.zupacademy.gerson.casadocodigo.model.Autor;
import br.com.zupacademy.gerson.casadocodigo.repository.RepositoryAutor;

@RestController
@RequestMapping(value = "/autor")
public class AutoresController {

	@Autowired
	private RepositoryAutor repositoryAutor;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorDto request) {
		Autor autor = request.toAutor();
		repositoryAutor.save(autor);
		return ResponseEntity.ok().body(request);
	}
}
