package br.com.zupacademy.gerson.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.gerson.casadocodigo.model.Autor;

public interface RepositoryAutor extends JpaRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

}
