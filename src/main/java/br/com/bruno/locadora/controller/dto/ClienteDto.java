package br.com.bruno.locadora.controller.dto;

import br.com.bruno.locadora.modelo.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDto {
	
	private Long id;
	private String nome;
	private String codigo;
	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.codigo = cliente.getCodigoDoCLiente();
	}

	public String getCodigo() {
		return codigo;
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
	

}
