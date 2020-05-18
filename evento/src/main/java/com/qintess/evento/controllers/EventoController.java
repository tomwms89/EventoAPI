package com.qintess.evento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.evento.dados.EventoRepos;
import com.qintess.evento.entidades.Evento;

@RestController
@RequestMapping("/api")
public class EventoController {
	
	@Autowired
	private EventoRepos eventoRepos;
	
	@GetMapping("/evento")
	public List<Evento> getEvento() {
		return eventoRepos.findAll();
	}
	
	@PostMapping("/evento")
	public void criaEvento(@RequestBody Evento evento) {
		eventoRepos.save(evento);
	}

}
