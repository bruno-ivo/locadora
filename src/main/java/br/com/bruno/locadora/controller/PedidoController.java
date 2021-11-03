package br.com.bruno.locadora.controller;

import br.com.bruno.locadora.modelo.Pedido;
import br.com.bruno.locadora.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listarPedidos (){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pedido> cadastrarPedido (@RequestBody Pedido pedido, UriComponentsBuilder uriBuilder){
        pedido = new Pedido();
        pedidoRepository.save(pedido);

        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

}
