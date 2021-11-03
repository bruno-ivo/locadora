package br.com.bruno.locadora.repository;

import br.com.bruno.locadora.modelo.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

	List<Filme> findByNomeDoFilme(String nomeDoFilme);

    Filme findByTipo(String tipo);
}
