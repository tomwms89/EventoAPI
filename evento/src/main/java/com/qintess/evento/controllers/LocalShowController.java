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

import com.qintess.evento.dados.LocalShowRepos;
import com.qintess.evento.entidades.LocalShow;

@RestController
@RequestMapping("/api")
public class LocalShowController {
	
	@Autowired
	private LocalShowRepos localShowRepos;
	
	@GetMapping("/localShow")
	public List<LocalShow> getLocalShow() {
		return localShowRepos.findAll();
	}
	
	@GetMapping("/localshow/{localShowId}")
	public ResponseEntity<LocalShow> getLocalShowId(@PathVariable("id") int localShowId) {
		Optional<LocalShow> optLocalShow = localShowRepos.findById(localShowId);
		
		if (optLocalShow.isPresent()) {
			return new ResponseEntity<LocalShow>(optLocalShow.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/localShow")
	public void criaLocal(@RequestBody LocalShow localShow) {
		localShowRepos.save(localShow);
	}
	
	@PutMapping("/localshow/{localShowId}")
	public ResponseEntity<LocalShow> atualizaLocalShow(@PathVariable("id") int localShowId, @RequestBody LocalShow localShow) {
		Optional<LocalShow> optLocalShow = localShowRepos.findById(localShowId);
		
		if (optLocalShow.isPresent()) {
			LocalShow theLocalShow = optLocalShow.get();
			theLocalShow.setNomeLocal(localShow.getNomeLocal());
			theLocalShow.setEndereco(localShow.getEndereco());
			theLocalShow.setCapacidade(localShow.getCapacidade());
			
			return new ResponseEntity<LocalShow>(theLocalShow, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/localshow/{localShowId}")
	public ResponseEntity<Object> deletaLocalShow(@PathVariable("id") int localShowId) {
		Optional<LocalShow> optLocalShow = localShowRepos.findById(localShowId);
		
		if (optLocalShow.isPresent()) {
			localShowRepos.delete(optLocalShow.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
