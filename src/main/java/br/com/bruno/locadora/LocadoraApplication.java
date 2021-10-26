package br.com.bruno.locadora;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bruno.locadora.service.CrudClienteService;

@SpringBootApplication
public class LocadoraApplication implements CommandLineRunner {
	
	@Autowired
	CrudClienteService clienteService;
	
	private boolean system = true;
	
	public LocadoraApplication(CrudClienteService clienteService) {
		this.clienteService = clienteService;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner  = new Scanner(System.in);
		
		while(system) {
			System.out.println("Bem vindo a locadora Filmes+1, em que posso te ajudar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Área do Cliente");
			
			int action = scanner.nextInt();
			if(action == 1) {
				clienteService.inicial(scanner);
			} else {
				system = false;
			}
		}
		
	}

}
