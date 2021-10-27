package br.com.bruno.locadora.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoFilme;
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private TipoDeMidia tipo;
	
	
	public Filme() {
	}
	
	public Filme(String nomeDoFilme, BigDecimal valor, TipoDeMidia tipo) {
		super();
		this.nomeDoFilme = nomeDoFilme;
		this.valor = valor;
		this.tipo = tipo;
	}
	public TipoDeMidia getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeMidia tipo) {
		this.tipo = tipo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeDoFilme() {
		return nomeDoFilme;
	}
	public void setNomeDoFilme(String nomeDoFilme) {
		this.nomeDoFilme = nomeDoFilme;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Filme [Titulo : " + nomeDoFilme + ", valor = " + valor + ", tipo = " + tipo + "]";
	}	
	

}
