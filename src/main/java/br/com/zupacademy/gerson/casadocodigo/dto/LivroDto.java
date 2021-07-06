package br.com.zupacademy.gerson.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.gerson.casadocodigo.controller.validacao.ValorUnico;
import br.com.zupacademy.gerson.casadocodigo.model.Autor;
import br.com.zupacademy.gerson.casadocodigo.model.Categoria;
import br.com.zupacademy.gerson.casadocodigo.model.Livro;

public class LivroDto {

	@NotBlank
	@ValorUnico(classe = Livro.class, value = "titulo")
	private String titulo;

	@NotBlank
	@Length(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private int n_paginas;

	@NotBlank
	@ValorUnico(classe = Livro.class, value = "isbn")
	private String isbn;

	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate data_publicacao;

	@NotNull
	private Long id_categoria;

	@NotNull
	private Long id_autor;

	public LivroDto(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int n_paginas, @NotBlank String isbn,
			@NotNull Long id_categoria, @NotNull Long id_autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.n_paginas = n_paginas;
		this.isbn = isbn;
		this.id_categoria = id_categoria;
		this.id_autor = id_autor;
	}

	public void setData_publicacao(LocalDate data_publicacao) {
		this.data_publicacao = data_publicacao;
	}

	public Livro toLivro(EntityManager em) {
		Categoria c = em.find(Categoria.class, id_categoria);
		Autor a = em.find(Autor.class, id_autor);

		Assert.state(c != null, "Categoria não existe");
		Assert.state(a != null, "autor não existe");

		return new Livro(titulo, resumo, sumario, preco, n_paginas, isbn, data_publicacao, c, a);
	}

}
