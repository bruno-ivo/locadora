package br.com.bruno.locadora.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.locadora.modelo.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
