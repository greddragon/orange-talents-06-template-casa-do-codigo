package br.com.zupacademy.gerson.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zupacademy.gerson.casadocodigo.model.Livro;

public class DetalhesLivroDto {
	private String titulo;
	private DetalhesAutorDto autor;
	private String categoria;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int n_paginas;
	private String isbn;
	private String data_publicacao;

	public DetalhesLivroDto(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.categoria = livro.getCategoria().getNome();
		this.autor = new DetalhesAutorDto(livro.getAutor());
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.n_paginas = livro.getN_paginas();
		this.isbn = livro.getIsbn();
		this.data_publicacao = livro.getData_publicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

	public String getTitulo() {
		return titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public DetalhesAutorDto getAutor() {
		return autor;
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

	public String getData_publicacao() {
		return data_publicacao;
	}

}
