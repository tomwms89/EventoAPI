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

import com.qintess.evento.dados.UsuarioRepos;
import com.qintess.evento.entidades.Usuario;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepos usuarioRepos;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioRepos.findAll();
	}
	
	@GetMapping("/usuarios/{usuarioId}")
	public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable("id") int usuarioId) {
		Optional<Usuario> optUsuario = usuarioRepos.findById(usuarioId);
		
		if (optUsuario.isPresent()) {
			return new ResponseEntity<Usuario>(optUsuario.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/usuarios")
	public void criaUsuario(@RequestBody Usuario usuario) {
		usuarioRepos.save(usuario);
	}
	
	@PutMapping("/usuarios/{usuarioId}")
	public ResponseEntity<Usuario> atualizaUsuario(@PathVariable("id") int usuarioId, @RequestBody Usuario usuario){
		Optional<Usuario> optUsuario = usuarioRepos.findById(usuarioId);
		
		if (optUsuario.isPresent()) {
			Usuario theUsuario = optUsuario.get();
			theUsuario.setNome(usuario.getNome());
			theUsuario.setSobrenome(usuario.getSobrenome());
			theUsuario.setEmail(usuario.getEmail());
			theUsuario.setTelefone(usuario.getTelefone());
			theUsuario.setSenha(usuario.getSenha());

			return new ResponseEntity<Usuario>(theUsuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/usuarios/{usuarioId}")
	public ResponseEntity<Object> deletaUsuario(@PathVariable("id") int usuarioId) {
		Optional<Usuario> optUsuario = usuarioRepos.findById(usuarioId);
		
		if (optUsuario.isPresent()) {
			usuarioRepos.delete(optUsuario.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
