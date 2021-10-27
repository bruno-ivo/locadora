package br.com.bruno.locadora.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bruno.locadora.controller.dto.FilmeDto;
import br.com.bruno.locadora.controller.form.FilmeForm;
import br.com.bruno.locadora.modelo.Filme;
import br.com.bruno.locadora.repository.FilmeRepository;

@RestController
@RequestMapping(value = "/filmes")
public class FilmeController {	
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	@GetMapping
	public List<FilmeDto> listarFilmes (String nomeDoFilme){
		if (nomeDoFilme == null) {
			List<Filme> filmes = filmeRepository.findAll();
			return FilmeDto.converter(filmes);			
		} else {
			List<Filme> filmes = filmeRepository.findByNomeDoFilme(nomeDoFilme);
			return FilmeDto.converter(filmes);	
		}
	}
	
	@PostMapping
	public ResponseEntity<FilmeDto> cadastrarFilme (@RequestBody FilmeForm form, UriComponentsBuilder uriBuilder){
		Filme filme = form.converter();
		filmeRepository.save(filme);
		URI uri = uriBuilder.path("/filmes/{id}").buildAndExpand(filme.getId()).toUri();
		return ResponseEntity.created(uri).body(new FilmeDto(filme));
	}
	

}
