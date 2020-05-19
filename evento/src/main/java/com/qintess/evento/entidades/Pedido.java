package com.qintess.evento.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Usuario usuarioId;
	
	@ManyToOne
	private Evento eventoId;
	
	@OneToMany(mappedBy = "pedidoId")
	private List<Ingresso> ingresso;
	
	private int quantidade;
	
	private double valor;
	
	
	public Pedido() {
		
	}

	public Pedido(Usuario usuarioId, Evento eventoId, List<Ingresso> ingresso, int quantidade, double valor) {
		this.usuarioId = usuarioId;
		this.eventoId = eventoId;
		this.ingresso = ingresso;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Evento getEventoId() {
		return eventoId;
	}

	public void setEventoId(Evento eventoId) {
		this.eventoId = eventoId;
	}

	public List<Ingresso> getIngresso() {
		return ingresso;
	}

	public void setIngresso(List<Ingresso> ingresso) {
		this.ingresso = ingresso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", usuarioId=" + usuarioId + ", eventoId=" + eventoId + ", ingresso=" + ingresso
				+ ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}
	
}
