package com.qintess.evento.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.evento.dados.PedidoRepos;
import com.qintess.evento.entidades.Pedido;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {
	
	@Autowired
	private PedidoRepos pedidoRepos;
	
	@GetMapping("/pedido")
	public List<Pedido> getPedido() {
		return pedidoRepos.findAll();
	}
	
	@GetMapping("/pedido/{pedidoId}")
	public ResponseEntity<Pedido> getPedidoId(@PathVariable("id") int pedidoId) {
		Optional<Pedido> optPedido = pedidoRepos.findById(pedidoId);
		
		if (optPedido.isPresent()) {
			return new ResponseEntity<Pedido>(optPedido.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/pedido")
	public void criaPedido(@RequestBody Pedido pedido) {
		pedidoRepos.save(pedido);
	}
	
	@PutMapping("/pedido/{pedidoId}")
	public ResponseEntity<Pedido> atualizaPedido(@PathVariable("id") int pedidoId, @RequestBody Pedido pedido) {
		Optional<Pedido> optPedido = pedidoRepos.findById(pedidoId);
		
		if (optPedido.isPresent()) {
			Pedido thePedido = optPedido.get();
			thePedido.setUsuarioId(pedido.getUsuarioId());
			thePedido.setEventoId(pedido.getEventoId());
			thePedido.setQuantidade(pedido.getQuantidade());
			thePedido.setValor(pedido.getValor());
			
			return new ResponseEntity<Pedido>(thePedido, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/pedido/{pedidoId}")
	public ResponseEntity<Object> deletaPedido(@PathVariable("id") int pedidoId) {
		Optional<Pedido> optPedido = pedidoRepos.findById(pedidoId);
		
		if (optPedido.isPresent()) {
			pedidoRepos.delete(optPedido.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
