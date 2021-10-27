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

import br.com.bruno.locadora.controller.dto.ClienteDto;
import br.com.bruno.locadora.controller.form.ClienteForm;
import br.com.bruno.locadora.modelo.Cliente;
import br.com.bruno.locadora.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<ClienteDto> listaClientes (String nomeDoCliente){
		if(nomeDoCliente == null) {
			List<Cliente> clientes = clienteRepository.findAll();
			return ClienteDto.converter(clientes);		
		} else {
			List<Cliente> clientes = clienteRepository.findByNome(nomeDoCliente);
			return ClienteDto.converter(clientes);	
		}
		
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrar (@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {
		Cliente cliente = form.converter();
		clienteRepository.save(cliente);		
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

}
