package com.bios.conta.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	
	@Id @GeneratedValue
	private long id;
	
	private String origem;
	
	private Date data;
	
	private Double valorTotal;
	
	private Boolean isMensal;
	
	private String formaPagamento;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Item> itens;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Boolean getIsMensal() {
		return isMensal;
	}

	public void setIsMensal(Boolean isMensal) {
		this.isMensal = isMensal;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
