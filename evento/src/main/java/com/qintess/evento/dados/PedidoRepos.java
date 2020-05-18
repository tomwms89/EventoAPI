package com.qintess.evento.dados;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.evento.entidades.Pedido;

public interface PedidoRepos extends JpaRepository<Pedido, Integer> {

}
