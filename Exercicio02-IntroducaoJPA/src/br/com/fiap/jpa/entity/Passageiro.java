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
@Table(name="T_PASSAGEIRO")
@SequenceGenerator(name="passageiro", sequenceName="SQ_T_PASSAGEIRO", allocationSize=1)
public class Passageiro {
	
	@Id
	@Column(name="cd_passageiro")
	@GeneratedValue(generator="passageiro", strategy= GenerationType.SEQUENCE)
	private int codigoPassageiro;
	
	@Column(name="nm_passageiro", length=100, nullable=false)
	private String nomePassageiro;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento", nullable=false)
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_geneo", nullable=false)
	private Genero descricaoGen;
	
	public Passageiro() {
		
	}

	public Passageiro(String nomePassageiro, Calendar dataNascimento, Genero descricaoGen) {
		super();
		this.nomePassageiro = nomePassageiro;
		this.dataNascimento = dataNascimento;
		this.descricaoGen = descricaoGen;
	}

	public int getCodigoPassageiro() {
		return codigoPassageiro;
	}

	public void setCodigoPassageiro(int codigoPassageiro) {
		this.codigoPassageiro = codigoPassageiro;
	}

	public String getNomePassageiro() {
		return nomePassageiro;
	}

	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getDescricaoGen() {
		return descricaoGen;
	}

	public void setDescricaoGen(Genero descricaoGen) {
		this.descricaoGen = descricaoGen;
	}

}
