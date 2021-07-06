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

import br.com.zupacademy.gerson.casadocodigo.dto.EstadoDto;
import br.com.zupacademy.gerson.casadocodigo.model.Estado;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@PersistenceContext
	EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoDto request) {
		Estado estado = request.toEstado(em);
		em.persist(estado);
		return ResponseEntity.ok().body(estado);
	}
}
