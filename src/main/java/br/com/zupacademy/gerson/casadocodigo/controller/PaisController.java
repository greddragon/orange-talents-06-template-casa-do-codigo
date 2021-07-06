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

import br.com.zupacademy.gerson.casadocodigo.dto.PaisDto;
import br.com.zupacademy.gerson.casadocodigo.model.Pais;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@PersistenceContext
	EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisDto request) {
		Pais pais = request.toPais();
		em.persist(pais);
		return ResponseEntity.ok().body(pais);
	}
}
