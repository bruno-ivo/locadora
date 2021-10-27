package br.com.bruno.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.locadora.modelo.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

	List<Filme> findByNomeDoFilme(String nomeDoFilme);

}
