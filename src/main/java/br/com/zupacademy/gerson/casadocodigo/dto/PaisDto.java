package br.com.zupacademy.gerson.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.gerson.casadocodigo.controller.validacao.ValorUnico;
import br.com.zupacademy.gerson.casadocodigo.model.Pais;

public class PaisDto {

	@NotBlank
	@ValorUnico(classe = Pais.class, value = "nome")
	private String nome;

	@JsonCreator
	public PaisDto(@JsonProperty("nome") @NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public Pais toPais() {

		return new Pais(nome);
	}

}
