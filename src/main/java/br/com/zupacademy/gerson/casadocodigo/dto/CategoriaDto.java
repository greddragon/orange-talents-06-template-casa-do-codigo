package br.com.zupacademy.gerson.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gerson.casadocodigo.model.Categoria;

public class CategoriaDto {

	@NotBlank
	private String nome;

	@JsonCreator
	public CategoriaDto(@JsonProperty("nome") @NotBlank String nome) {
		super();
		this.nome = nome;

	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "CategoriaDto [nome=" + nome + "]";
	}

	public Categoria toCategoria() {
		return new Categoria(this.nome);
	}

}
