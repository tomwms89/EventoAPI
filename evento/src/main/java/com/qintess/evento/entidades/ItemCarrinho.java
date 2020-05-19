package com.qintess.evento.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ItemCarrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Carrinho carrinho;
		
	@OneToOne
	private Evento evento;
	
	@OneToMany
	private List<Ingresso> ingresso;
	
	private int quantidade;
		
	private BigDecimal subTotal;
	
	
	public ItemCarrinho() {
		
	}

	public ItemCarrinho(Carrinho carrinho, Evento evento, List<Ingresso> ingresso, int quantidade,
			BigDecimal subTotal) {
		this.carrinho = carrinho;
		this.evento = evento;
		this.ingresso = ingresso;
		this.quantidade = quantidade;
		this.subTotal = subTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
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

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "ItemCarrinho [carrinho=" + carrinho + ", evento=" + evento + ", ingresso=" + ingresso + ", quantidade="
				+ quantidade + ", subTotal=" + subTotal + "]";
	}
	
}
