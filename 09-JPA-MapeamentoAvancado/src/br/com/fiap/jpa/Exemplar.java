package br.com.fiap.jpa;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_EXEMPLAR")
@IdClass(ExemplarPK.class)
public class Exemplar {

	@Id
	@Column(name="nr_exemplar")
	private int numero;
	
	@Column(name="dt_tombo")
	private Calendar dataTombo;
	
	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="nr_isbn")
	private Livro livro;
	
	public Exemplar() {
		
	}

	public Exemplar(int numero, Calendar dataTombo, Livro livro) {
		super();
		this.numero = numero;
		this.dataTombo = dataTombo;
		this.livro = livro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Calendar getDataTombo() {
		return dataTombo;
	}

	public void setDataTombo(Calendar dataTombo) {
		this.dataTombo = dataTombo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
