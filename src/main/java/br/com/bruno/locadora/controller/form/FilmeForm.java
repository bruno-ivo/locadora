package br.com.bruno.locadora.controller.form;

import java.math.BigDecimal;

import br.com.bruno.locadora.modelo.Filme;
import br.com.bruno.locadora.modelo.TipoDeMidia;

public class FilmeForm {
	
	private String nomeDoFilme;
	private BigDecimal valor;
	private TipoDeMidia tipo;
	
	
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
	public TipoDeMidia getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeMidia tipo) {
		this.tipo = tipo;
	}
	
	
	public Filme converter() {
		return new Filme(nomeDoFilme, valor, tipo);
	}
	

}
