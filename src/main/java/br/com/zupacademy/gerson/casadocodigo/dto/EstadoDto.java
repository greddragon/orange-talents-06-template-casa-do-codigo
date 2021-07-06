package br.com.zupacademy.gerson.casadocodigo.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zupacademy.gerson.casadocodigo.model.Estado;
import br.com.zupacademy.gerson.casadocodigo.model.Pais;

public class EstadoDto {

	@NotBlank
	private String nome;
	@NotNull
	private Long id_pais;

	public EstadoDto(@NotBlank String nome, @NotNull Long id_pais) {
		super();
		this.nome = nome;
		this.id_pais = id_pais;
	}

	public String getNome() {
		return nome;
	}

	public Estado toEstado(EntityManager em) {
		Pais pais = em.find(Pais.class, id_pais);

		Assert.state(pais != null, "País não existe");

		Query query = em.createQuery("SELECT e FROM Estado e JOIN e.pais p where e.nome =:nome");
		query.setParameter("nome", nome);
		List<?> estadoNomeExiste = query.getResultList();

		Assert.state(estadoNomeExiste.size() <= 0, "País não pode ter estados com o mesmo nome");

		return new Estado(nome, pais);
	}

}
