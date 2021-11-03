package br.com.bruno.locadora.controller.form;

import br.com.bruno.locadora.modelo.Cliente;
import br.com.bruno.locadora.repository.ClienteRepository;

public class ClienteForm {
	
	private String nome;
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente converter() {
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setCodigoDoCLiente(codigo);
		return c;
	}


    public Cliente atualizar(long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getById(id);
		cliente.setNome(this.nome);
		cliente.setCodigoDoCLiente(this.codigo);
		return cliente;
    }
}
