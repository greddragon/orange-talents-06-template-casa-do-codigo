package br.com.zupacademy.gerson.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.gerson.casadocodigo.model.Categoria;

public interface RepositoryCategoria extends JpaRepository<Categoria, Long>{

	Optional<Categoria> findByNome(String nome);

}
