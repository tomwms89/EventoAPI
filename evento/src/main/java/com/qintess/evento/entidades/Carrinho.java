package com.qintess.evento.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "carrinho")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int quantidade;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	
	private BigDecimal valorTotal;
	
	
	public Carrinho() {
		
	}

	public Carrinho(int quantidade, Date data, BigDecimal valorTotal) {
		this.quantidade = quantidade;
		this.data = data;
		this.valorTotal = valorTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Carrinho [quantidade=" + quantidade + ", data=" + data + ", valorTotal=" + valorTotal
				+ "]";
	}
	
}
