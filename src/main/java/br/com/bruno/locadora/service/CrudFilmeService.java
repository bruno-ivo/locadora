package br.com.bruno.locadora.service;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.locadora.modelo.Filme;
import br.com.bruno.locadora.modelo.TipoDeMidia;
import br.com.bruno.locadora.repository.FilmeRepository;

@Service
public class CrudFilmeService {

	private boolean system = true;

	@Autowired
	private final FilmeRepository filmeRepository;

	public CrudFilmeService(FilmeRepository filmeRepository) {
		this.filmeRepository = filmeRepository;
	}

	public void inicial(Scanner scanner) {

		while (system) {
			System.out.println("Qual ação para filmes deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar um novo filme");
			System.out.println("2 - Atualizar um filme");
			System.out.println("3 - Exibir os filmes");
			System.out.println("4 - Deletar um filme");

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				salvarFilme(scanner);
				break;
			case 2:
				atualizarFilme(scanner);
				break;
			case 3:
				listarfilmes();
				break;
			case 4:
				deletarFilme(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void salvarFilme(Scanner scanner) {
		System.out.println("Por favor, digite o nome do Filme:");
		String nomeDoFilme = scanner.next();
		Filme filme = new Filme();		
		filme.setNomeDoFilme(nomeDoFilme);
		System.out.println("Por favor, digite o valor do filme:");
		BigDecimal valor = scanner.nextBigDecimal();
		filme.setValor(valor);
		System.out.println("Por favor, digite o tipo de midia, VHS ou DVD");
		String tipoMidia = scanner.next();
		filme.setTipo(TipoDeMidia.valueOf(tipoMidia));
		filmeRepository.save(filme);
		System.out.println("Cliente Cadastrado com sucesso");
	}

	private void atualizarFilme(Scanner scanner) {
		System.out.println("Por favor, digite o id do filme:");
		Long id = scanner.nextLong();
		System.out.println("Digite o nome do filme que quer alterar");
		String nomedoFilme = scanner.next();
		Filme filme = new Filme();
		filme.setId(id);
		filme.setNomeDoFilme(nomedoFilme);
		System.out.println("Por favor, digite o valor do filme:");
		BigDecimal valor = scanner.nextBigDecimal();
		filme.setValor(valor);
		System.out.println("Por favor, digite o tipo de midia, 1 para VHS, 2 para DVD");
		String tipoMidia = scanner.next();
		filme.setTipo(TipoDeMidia.valueOf(tipoMidia));
		filmeRepository.save(filme);
		System.out.println("Filme Atualizado com sucesso com sucesso");
	}

	private void listarfilmes() {
		Iterable<Filme> filmes = filmeRepository.findAll();
		filmes.forEach(filme -> System.out.println(filme));
	}

	private void deletarFilme(Scanner scanner) {
		System.out.println("Por favor, digite o id do filme:");
		Long id = scanner.nextLong();
		filmeRepository.deleteById(id);
		System.out.println("Filme Deletado com sucesso");
	}

}
