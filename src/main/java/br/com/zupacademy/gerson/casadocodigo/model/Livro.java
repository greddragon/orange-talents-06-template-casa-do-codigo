package br.com.zupacademy.gerson.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
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
	private String isbn;

	@NotNull
	@Future
	private LocalDate data_publicacao;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Autor autor;

	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int n_paginas, @NotBlank String isbn,
			@NotNull @Future LocalDate data_publicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.n_paginas = n_paginas;
		this.isbn = isbn;
		this.data_publicacao = data_publicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getN_paginas() {
		return n_paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getData_publicacao() {
		return data_publicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

}
