package com.qintess.evento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.evento.dados.PedidoRepos;
import com.qintess.evento.entidades.Pedido;

@RestController
@RequestMapping("/api")
public class PedidoController {
	
	@Autowired
	private PedidoRepos pedidoRepos;
	
	@GetMapping("/pedido")
	public List<Pedido> getPedido() {
		return pedidoRepos.findAll();
	}
	
	@PostMapping("/pedido")
	public void criaPedido(@RequestBody Pedido pedido) {
		pedidoRepos.save(pedido);
	}

}
