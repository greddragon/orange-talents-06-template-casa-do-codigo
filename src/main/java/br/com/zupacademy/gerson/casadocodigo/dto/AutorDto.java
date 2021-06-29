package br.com.zupacademy.gerson.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.gerson.casadocodigo.model.Autor;

public class AutorDto {

	@NotNull
	@NotBlank
	private String nome;
	@NotNull
	@Email
	private String email;
	@NotNull
	@NotBlank
	@Length(max = 400)
	private String descricao;

	public AutorDto(@NotNull @NotBlank String nome, @NotNull @Email String email,
			@NotNull @NotBlank @Length(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "AutorDto [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
	}

	public Autor toAutor() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
