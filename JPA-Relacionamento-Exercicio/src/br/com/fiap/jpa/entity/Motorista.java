package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MOTORISTA")
@SequenceGenerator(name="motorista", sequenceName="SQ_T_MOTORISTA", allocationSize=1)
public class Motorista {
	
	@Id
	@Column(name="cd_motorista")
	@GeneratedValue(generator="motorista",strategy=GenerationType.SEQUENCE)
	private int codMoto;
	
	@Column(name="nm_motorista",nullable=false, length=100)
	private String nome;

	public Motorista() {
		
	}
	public Motorista(String nome) {
		super();
		this.nome = nome;
	}

	public int getCodMoto() {
		return codMoto;
	}

	public void setCodMoto(int codMoto) {
		this.codMoto = codMoto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
