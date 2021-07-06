package br.com.zupacademy.gerson.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.gerson.casadocodigo.controller.validacao.CPFOrCNPJ;
import br.com.zupacademy.gerson.casadocodigo.controller.validacao.ValorUnico;
import br.com.zupacademy.gerson.casadocodigo.model.Cliente;
import br.com.zupacademy.gerson.casadocodigo.model.Estado;
import br.com.zupacademy.gerson.casadocodigo.model.Pais;

public class ClienteDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CPFOrCNPJ
	@ValorUnico(classe = Cliente.class, value = "documento")
	private String documento;
	@NotBlank
	@Email
	@ValorUnico(classe = Cliente.class, value = "email")
	private String email;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	private Long id_pais;
	private Long id_estado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public ClienteDto(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String documento,
			@NotBlank @Email String email, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long id_pais, Long id_estado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.email = email;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.id_pais = id_pais;
		this.id_estado = id_estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toCliente(EntityManager em) {
		Pais pais = em.find(Pais.class, id_pais);

		Estado estado;
		if (id_estado != null) {
			estado = em.find(Estado.class, id_estado);
		} else {
			estado = null;
		}

		Assert.state(pais != null, "Pais não existe");

		return new Cliente(nome, sobrenome, documento, email, endereco, complemento, cidade, pais, estado, telefone,
				cep);
	}

}
