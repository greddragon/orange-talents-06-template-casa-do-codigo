package br.com.zupacademy.gerson.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@Email
	private String email;
	@NotBlank
	@Length(max = 400)
	private String descricao;

	@SuppressWarnings("unused")
	private LocalDateTime data_registro;

	@Deprecated
	public Autor() {

	}

	public Autor(@NotBlank String nome, @Email String email, @NotBlank @Length(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.data_registro = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getData_registro() {
		return data_registro;
	}
	
	

}
