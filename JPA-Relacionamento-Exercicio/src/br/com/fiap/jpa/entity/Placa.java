package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PLACA")
@SequenceGenerator(name="placa", sequenceName="SQ_T_PLACA", allocationSize=1)
public class Placa {
	
	@Id
	@Column(name="cd_placa")
	@GeneratedValue(generator="placa",strategy=GenerationType.SEQUENCE)
	private int codPlaca;
	
	@Column(name="nr_placa", length=50)
	private int numero ;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_pais")
	private Pais pais;
	
	@OneToOne(fetch= FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="nr_renavam")
	private Carro carro;

	public Placa() {
		
	}
	public Placa(int numero, Pais pais, Carro carro) {
		super();
		this.numero = numero;
		this.pais = pais;
		this.carro = carro;
	}

	public int getCodPlaca() {
		return codPlaca;
	}

	public void setCodPlaca(int codPlaca) {
		this.codPlaca = codPlaca;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
}
