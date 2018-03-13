package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PAGAMENTO")
@SequenceGenerator(name="pagamento",sequenceName="SQ_T_PAGAMENTO",allocationSize=1)
public class Pagamento {
	
	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(generator="pagamento", strategy=GenerationType.SEQUENCE)
	private int codPagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_pagamento", nullable=false)
	private Calendar DataPagamento;
	
	@Column(name="vl_pagamento",nullable=false)
	private float valorPagamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_forma_pagamento", nullable= false, length=50)
	private FormaPagamento descricaoFormaPagamento;
	
	public Pagamento() {
		
	}

	public Pagamento(Calendar dataPagamento, float valorPagamento, FormaPagamento descricaoFormaPagamento) {
		super();
		DataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.descricaoFormaPagamento = descricaoFormaPagamento;
	}

	public int getCodPagamento() {
		return codPagamento;
	}

	public void setCodPagamento(int codPagamento) {
		this.codPagamento = codPagamento;
	}

	public Calendar getDataPagamento() {
		return DataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		DataPagamento = dataPagamento;
	}

	public float getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public FormaPagamento getDescricaoFormaPagamento() {
		return descricaoFormaPagamento;
	}

	public void setDescricaoFormaPagamento(FormaPagamento descricaoFormaPagamento) {
		this.descricaoFormaPagamento = descricaoFormaPagamento;
	}
}
