package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_CARRO")
//@SequenceGenerator(name="carro", sequenceName="SQ_T_CARRO", allocationSize=1)
public class Carro {
	
	@Id
	@Column(name="nr_renavam")
	//@GeneratedValue(generator="carro",strategy=GenerationType.SEQUENCE)
	private int renavam;
	
	@Column(name="ds_cor")
	private String cor;
	
	@Column(name="nr_ano")
	private int numeroAno;
	
	@OneToOne(mappedBy="carro")
	private Placa placa;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_proprietario")
	private Proprietario proprietario;
	
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
	}

	public Carro() {
		
	}

	public Carro(int renavam, String cor, int numeroAno) {
		super();
		this.renavam = renavam;
		this.cor = cor;
		this.numeroAno = numeroAno;
	}

	public int getRenavam() {
		return renavam;
	}

	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getNumeroAno() {
		return numeroAno;
	}

	public void setNumeroAno(int numeroAno) {
		this.numeroAno = numeroAno;
	}
}
