package br.com.zupacademy.gerson.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	private String documento;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@ManyToOne
	private Pais pais;
	@ManyToOne
	private Estado estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public Cliente(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank @Email String email, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, Pais pais, Estado estado, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.email = email;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
