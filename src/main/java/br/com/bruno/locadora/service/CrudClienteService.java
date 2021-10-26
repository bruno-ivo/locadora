package br.com.bruno.locadora.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.locadora.modelo.Cliente;
import br.com.bruno.locadora.repository.ClienteRepository;

@Service
public class CrudClienteService {
	
	private boolean system = true;
	
	@Autowired
	private final ClienteRepository clienteRepository;
	
	public CrudClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("Qual ação de cliente deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar um novo cliente");
			System.out.println("2 - Atualizar um cliente");
			System.out.println("3 - Exibir os clientes");
			System.out.println("4 - Deletar um cliente");
			
			int action = scanner.nextInt();
			switch (action) {
			case 1:
				salvarCliente(scanner);			
				break;
			case 2:
				atualizarCliente(scanner);			
				break;
			case 3:
				listarClientes();
				break;
			case 4:
				deletarCliente(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}
	
	private void salvarCliente(Scanner scanner) {
		System.out.println("Por favor, digite o nome do Cliente:");
		String nome = scanner.next();
		Cliente cliente  = new Cliente();
		cliente.setNome(nome);
		clienteRepository.save(cliente);
		System.out.println("Cliente Cadastrado com sucesso");
	}
	
	private void atualizarCliente (Scanner scanner) {
		System.out.println("Por favor, digite a matricula do Cliente:");
		Long id = scanner.nextLong();
		System.out.println("Digite o nome que quer alterar");
		String nome = scanner.next();
		
		Cliente cliente  = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		clienteRepository.save(cliente);
		System.out.println("Cliente Atualizado com sucesso");		
	}
	
	private void listarClientes() {
		Iterable <Cliente> clientes = clienteRepository.findAll();
		clientes.forEach(cliente -> System.out.println(cliente));
	}
	
	private void deletarCliente(Scanner scanner) {
		System.out.println("Por favor, digite o cadastro do Cliente:");
		Long id = scanner.nextLong();
		clienteRepository.deleteById(id);
		System.out.println("Cliente Deletado com sucesso");	
	}

}
