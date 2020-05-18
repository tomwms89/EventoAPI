package com.qintess.evento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/usuarios")
	public void criaUsuario(@RequestBody Usuario usuario) {
		usuarioRepos.save(usuario);
	}

}
