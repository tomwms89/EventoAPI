package com.qintess.evento.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.evento.entidades.Evento;

public interface EventoRepos extends JpaRepository<Evento, Integer> {

}
