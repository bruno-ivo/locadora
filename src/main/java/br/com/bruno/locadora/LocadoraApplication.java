package br.com.bruno.locadora;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bruno.locadora.service.CrudClienteService;
import br.com.bruno.locadora.service.CrudFilmeService;

@SpringBootApplication
public class LocadoraApplication implements CommandLineRunner {

	@Autowired
	CrudClienteService clienteService;

	@Autowired
	CrudFilmeService filmeService;

	private boolean system = true;

	
	public LocadoraApplication(CrudClienteService clienteService, CrudFilmeService filmeService) {
		this.clienteService = clienteService;
		this.filmeService = filmeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Bem vindo a locadora Filmes+1, em que posso te ajudar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Área dos Clientes");
			System.out.println("2 - Área dos Filmes");
			System.out.println("3 - Fazer seu Pedido");

			int action = scanner.nextInt();
			if (action == 1) {
				clienteService.inicial(scanner);

			} else if (action == 2) {
				filmeService.inicial(scanner);
			} else if (action == 3) {
				System.out.println("Em produção");
			} else {
				system = false;
			}
		}

	}

}
