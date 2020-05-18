package com.qintess.evento.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.evento.entidades.Usuario;

public interface UsuarioRepos extends JpaRepository<Usuario, Integer> {

}
