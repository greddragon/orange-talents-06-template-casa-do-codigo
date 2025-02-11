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

import br.com.zupacademy.gerson.casadocodigo.dto.CategoriaDto;
import br.com.zupacademy.gerson.casadocodigo.model.Categoria;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@PersistenceContext
	EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaDto request) {
		Categoria categoria = request.toCategoria();
		em.persist(categoria);
		return ResponseEntity.ok().body(request);
	}
}
