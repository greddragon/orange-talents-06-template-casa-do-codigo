package br.com.zupacademy.gerson.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gerson.casadocodigo.dto.AutorDto;
import br.com.zupacademy.gerson.casadocodigo.model.Autor;

@RestController
@RequestMapping(value = "/autor")
public class AutoresController {

	@PersistenceContext
	EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorDto request) {
		Autor autor = request.toAutor();
		em.persist(autor);
		return ResponseEntity.ok().body(request);
	}
}
