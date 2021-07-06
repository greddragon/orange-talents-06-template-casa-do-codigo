package br.com.zupacademy.gerson.casadocodigo.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import br.com.zupacademy.gerson.casadocodigo.model.Livro;

public class ListaLivros {

	private Long id;
	private String titulo;

	public ListaLivros(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<ListaLivros> toLista(EntityManager em) {

		List<Livro> listaResultado = em.createQuery("SELECT l FROM Livro l", Livro.class).getResultList();

		return listaResultado.stream().map(livro -> new ListaLivros(livro.getId(), livro.getTitulo()))
				.collect(Collectors.toList());

	}

}
