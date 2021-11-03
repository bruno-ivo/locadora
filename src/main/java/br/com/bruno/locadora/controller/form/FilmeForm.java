package br.com.bruno.locadora.controller.form;

import br.com.bruno.locadora.modelo.Filme;
import br.com.bruno.locadora.modelo.TipoDeMidiaEnum;
import br.com.bruno.locadora.repository.FilmeRepository;

import java.math.BigDecimal;

public class FilmeForm {
	
	private String nomeDoFilme;

	private String tipo;
	private String codigo;

	private BigDecimal valorDoFilme;

	public BigDecimal getValorUnitarioDoFilme() {
		return valorDoFilme;
	}

	public void setValorUnitarioDoFilme(BigDecimal valorUnitarioDoFilme) {
		this.valorDoFilme = valorUnitarioDoFilme;
	}

	public String getNomeDoFilme() {
		return nomeDoFilme;
	}
	public void setNomeDoFilme(String nomeDoFilme) {
		this.nomeDoFilme = nomeDoFilme;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Filme converter() {
		Filme f = new Filme();
		f.setNomeDoFilme(nomeDoFilme);
		f.setCodigoDoFilme(codigo);
		f.setTipo(TipoDeMidiaEnum.valueOf(tipo));
		f.setValorUnitarioDoFilme(valorDoFilme);

		return f;
	}


    public Filme atualizar(long id, FilmeRepository filmeRepository) {
		Filme f = new Filme();
		f.setNomeDoFilme(this.nomeDoFilme);
		f.setCodigoDoFilme(this.codigo);
		f.setTipo(TipoDeMidiaEnum.valueOf(tipo));
		f.setValorUnitarioDoFilme(valorDoFilme);

		return f;
    }
}