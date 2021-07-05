package br.com.zupacademy.gerson.casadocodigo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gerson.casadocodigo.dto.DetalhesLivroDto;
import br.com.zupacademy.gerson.casadocodigo.dto.ListaLivros;
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

	@GetMapping("/lista-ivros")
	public ResponseEntity<?> listaLivros() {
		List<ListaLivros> lista = ListaLivros.toLista(em);

		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/detalhes-livro/{id}")
	public ResponseEntity<?> detalhesLivro(@PathVariable Long id) {
		Livro livro = em.find(Livro.class, id);

		if (livro != null) {
			DetalhesLivroDto detalhesLivroDto = new DetalhesLivroDto(livro);
			return ResponseEntity.ok().body(detalhesLivroDto);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
