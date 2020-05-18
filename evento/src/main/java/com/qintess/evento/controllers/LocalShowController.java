package com.qintess.evento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/localShow")
	public void criaLocal(@RequestBody LocalShow localShow) {
		localShowRepos.save(localShow);
	}

}
