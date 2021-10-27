package br.com.bruno.locadora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.locadora.modelo.Pedido;

@RestController
public class PedidoController {
	
	@RequestMapping("/pedidos")
	public List<Pedido> lista(){
		return null;
	}

}
