package br.com.bruno.locadora.controller.form;

import br.com.bruno.locadora.modelo.Cliente;

public class ClienteForm {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente converter() {
		return new Cliente(nome);
	}
	
	

}
