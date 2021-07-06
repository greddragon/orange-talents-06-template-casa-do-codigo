package br.com.zupacademy.gerson.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.gerson.casadocodigo.controller.validacao.ValorUnico;
import br.com.zupacademy.gerson.casadocodigo.model.Autor;

public class AutorDto {

	@NotBlank
	private String nome;
	@Email
	@ValorUnico(classe = Autor.class, value = "email")
	private String email;
	@NotBlank
	@Length(max = 400)
	private String descricao;

	public AutorDto(@NotBlank String nome, @Email String email, @NotBlank @Length(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor toAutor() {
		return new Autor(nome, email, descricao);
	}

}
