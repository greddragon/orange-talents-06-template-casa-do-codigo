package br.com.zupacademy.gerson.casadocodigo.dto;

import br.com.zupacademy.gerson.casadocodigo.model.Autor;

public class DetalhesAutorDto {

	private String nome;
	private String descricao;

	public DetalhesAutorDto(Autor autor) {
		super();
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
