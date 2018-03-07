package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_EMPRESA")
public class Empresa {
	@Id
	@Column(name="cd_cnpj", length=20)
	private String cnpj; //cd_cnpj varchar2(20)
	
	@Column(name="nm_empresa", nullable=false, length=100)
	private String nome;
	
	@Column(name="vl_faturamento")
	private double faturamento;

	public Empresa() {
		
	}
	
	public Empresa(String cnpj, String nome, double faturamento) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.faturamento = faturamento;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(float faturamento) {
		this.faturamento = faturamento;
	}

}
