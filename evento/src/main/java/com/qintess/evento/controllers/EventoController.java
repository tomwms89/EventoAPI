package com.qintess.evento.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.evento.dados.EventoRepos;
import com.qintess.evento.dados.LocalShowRepos;
import com.qintess.evento.entidades.Evento;

@RestController
@RequestMapping("/api")
public class EventoController {
	
	@Autowired
	private EventoRepos eventoRepos;
	
	@Autowired
	private LocalShowRepos localShowRepos;
	
	@GetMapping("/evento")
	public List<Evento> getEvento() {
		return eventoRepos.findAll();
	}
	
	@GetMapping("/evento/{eventoId}")
	public ResponseEntity<Evento> getEventoPorId(@PathVariable("id") int eventoId) {
		Optional<Evento> optEvento = eventoRepos.findById(eventoId);
		
		if (optEvento.isPresent()) {
			return new ResponseEntity<Evento>(optEvento.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/evento")
	public void criaEvento(@RequestBody Evento evento) {
		eventoRepos.save(evento);
	}
	
	@PutMapping("/evento/{eventoId}")
	public ResponseEntity<Evento> atualizaEvento(@PathVariable("id") int eventoId, @RequestBody Evento evento) {
		Optional<Evento> optEvento = eventoRepos.findById(eventoId);
		
		if (optEvento.isPresent()) {
			Evento theEvento = optEvento.get();
			theEvento.setNome(evento.getNome());
			theEvento.setDescricao(evento.getDescricao());
			theEvento.setQtd_ingressos(evento.getQtd_ingressos());
			theEvento.setPreco(evento.getPreco());
			theEvento.setData(evento.getData());
			
			return new ResponseEntity<Evento>(theEvento, HttpStatus.OK);			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/evento/{eventoId}")
	public ResponseEntity<Object> deletaEvento(@PathVariable("id") int eventoId) {
		Optional<Evento> optEvento = eventoRepos.findById(eventoId);
		
		if (optEvento.isPresent()) {
			eventoRepos.delete(optEvento.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
