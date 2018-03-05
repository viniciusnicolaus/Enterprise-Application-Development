package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
//@SequenceGenerator(name="motorista", sequenceName="SQ_T_MOTORISTA", allocationSize=1)
public class Motorista {
	
	@Id
	@Column(name="nr_carteira")
	//@GeneratedValue(generator="motorista", strategy = GenerationType.SEQUENCE)
	private int numeroCarteira; // nr_carteira *
	
	@Column(name="nm_motorista", length=150, nullable=false)
	private String nomeMotorista; //varchar150 nm_motorista *
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar data; // dt_nascimento
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] carteira; // fl_carteira lob
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length=50)
	private Genero genero; // enum ds_genero
	
	public Motorista() {
		
	}
	
	public Motorista(int numeroCarteira, String nomeMotorista, Calendar data, byte[] carteira, Genero genero) {
		super();
		this.numeroCarteira = numeroCarteira;
		this.nomeMotorista = nomeMotorista;
		this.data = data;
		this.carteira = carteira;
		this.genero = genero;
	}

	public int getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(int numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public byte[] getCarteira() {
		return carteira;
	}

	public void setCarteira(byte[] carteira) {
		this.carteira = carteira;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
