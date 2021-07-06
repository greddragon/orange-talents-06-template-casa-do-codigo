package br.com.zupacademy.gerson.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gerson.casadocodigo.controller.validacao.ValorUnico;
import br.com.zupacademy.gerson.casadocodigo.model.Categoria;

public class CategoriaDto {

	@NotBlank
	@ValorUnico(classe = Categoria.class, value = "nome")
	private String nome;

	@JsonCreator
	public CategoriaDto(@JsonProperty("nome") @NotBlank String nome) {
		super();
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

	public Categoria toCategoria() {
		return new Categoria(nome);
	}

}
