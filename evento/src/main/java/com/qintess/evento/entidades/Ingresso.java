package com.qintess.evento.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Evento eventoId;
	
	@ManyToOne
	private LocalShow localShowId;
	
	
	public Ingresso() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Evento getEventoId() {
		return eventoId;
	}

	public void setEventoId(Evento eventoId) {
		this.eventoId = eventoId;
	}

	public LocalShow getLocalShowId() {
		return localShowId;
	}

	public void setLocalShowId(LocalShow localShowId) {
		this.localShowId = localShowId;
	}

	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", eventoId=" + eventoId + ", localShowId=" + localShowId + "]";
	}

}
