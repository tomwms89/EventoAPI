package com.qintess.evento.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String descricao;
	private int qtd_ingressos;
	private double preco;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	
	@ManyToOne
	private LocalShow localId;
	
	@OneToMany(mappedBy = "eventoId")
	private List<Ingresso> ingresso;
	
	@OneToMany(mappedBy = "id")
	private List<Pedido> pedido = new ArrayList<>();
	
	
	public Evento() {
		
	}

	public Evento(String nome, String descricao, int qtd_ingressos, double preco, Date data) {
		this.nome = nome;
		this.descricao = descricao;
		this.qtd_ingressos = qtd_ingressos;
		this.preco = preco;
		this.data = data;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtd_ingressos() {
		return qtd_ingressos;
	}

	public void setQtd_ingressos(int qtd_ingressos) {
		this.qtd_ingressos = qtd_ingressos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", qtd_ingressos=" + qtd_ingressos
				+ ", preco=" + preco + ", data=" + data + ", localId=" + localId + "]";
	}

}
