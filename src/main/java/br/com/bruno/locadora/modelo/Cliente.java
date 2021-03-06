package br.com.bruno.locadora.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	private String codigoDoCLiente;

	public String getCodigoDoCLiente() {
		return codigoDoCLiente;
	}

	public void setCodigoDoCLiente(String codigo) {
		this.codigoDoCLiente = codigo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Cliente [Matricula : " + codigoDoCLiente + "] " + ", [Nome: " + nome + "]";
	}
	
	

}
