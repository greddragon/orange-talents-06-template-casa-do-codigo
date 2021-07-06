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

import br.com.zupacademy.gerson.casadocodigo.dto.ClienteDto;
import br.com.zupacademy.gerson.casadocodigo.model.Cliente;

@RestController
@RequestMapping("/cadastro-cliente")
public class ClienteController {

	@PersistenceContext
	EntityManager em;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteDto request) {
		Cliente cliente = request.toCliente(em);
		em.persist(cliente);
		return ResponseEntity.ok().body(cliente.getId());
	}

}
