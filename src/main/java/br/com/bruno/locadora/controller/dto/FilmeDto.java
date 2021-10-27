package br.com.bruno.locadora.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bruno.locadora.modelo.Filme;
import br.com.bruno.locadora.modelo.TipoDeMidia;

public class FilmeDto {
	
	private Long id;
	private String nomeDoFilme;	
	private BigDecimal valor;	
	private TipoDeMidia tipo;
	
	public FilmeDto(Filme filme) {
		this.id = filme.getId();
		this.nomeDoFilme = filme.getNomeDoFilme();
		this.valor = filme.getValor();
		this.tipo = getTipo();
		
	}
	
	public Long getId() {
		return id;
	}
	public String getNomeDoFilme() {
		return nomeDoFilme;
	}	

	public BigDecimal getValor() {
		return valor;
	}

	public TipoDeMidia getTipo() {
		return tipo;
	}

	public static List<FilmeDto> converter(List<Filme> filmes) {
		return filmes.stream().map(FilmeDto::new).collect(Collectors.toList());
	}
	
	

}
