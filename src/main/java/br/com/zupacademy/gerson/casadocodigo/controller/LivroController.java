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

import br.com.zupacademy.gerson.casadocodigo.dto.LivroDto;
import br.com.zupacademy.gerson.casadocodigo.model.Livro;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@PersistenceContext
	EntityManager em;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroDto request) {
		Livro livro = request.toLivro(em);
		em.persist(livro);
		return ResponseEntity.ok().body(livro);
	}
}
