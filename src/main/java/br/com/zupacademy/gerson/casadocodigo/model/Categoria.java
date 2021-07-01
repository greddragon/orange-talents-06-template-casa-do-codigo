package br.com.zupacademy.gerson.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	private String nome;
	
	@Deprecated
	public Categoria() {
		
	}
	
	public Categoria(@NotNull @NotBlank String nome) {
		super();
		this.nome = nome;
	}
	
	
}
