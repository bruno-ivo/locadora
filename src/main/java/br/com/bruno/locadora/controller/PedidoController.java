package br.com.bruno.locadora.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bruno.locadora.modelo.Pedido;

@Controller
public class PedidoController {
	
	@RequestMapping("/pedidos")
	public List<Pedido> lista(){
		return null;
	}

}
