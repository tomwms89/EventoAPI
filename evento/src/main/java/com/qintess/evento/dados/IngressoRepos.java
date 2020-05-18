package com.qintess.evento.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.evento.entidades.Ingresso;

public interface IngressoRepos extends JpaRepository<Ingresso, Integer> {

}
