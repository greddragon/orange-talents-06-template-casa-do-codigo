package br.com.zupacademy.gerson.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotBlank
	private String nome;
	@NotNull @Email
	private String email;
	@NotNull @NotBlank @Length(max = 400)
	private String descricao;

	private LocalDateTime data_registro;

	public Autor(@NotNull @NotBlank String nome, @NotNull @Email String email,
			@NotNull @NotBlank @Length(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.data_registro =  LocalDateTime.now();
	}
	
	
}
