package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="T_LIVRO")
@SequenceGenerator(name="livro",sequenceName="SQ_T_LIVRO",allocationSize=1)
public class Livro {
	
	@Id
	@Column(name="cd_isbn")
	@GeneratedValue(generator="livro",strategy=GenerationType.SEQUENCE)
	private int isbn;
	
	@Column(name="nm_livro", nullable=false, length=200)
	private String titulo;
	
	@Column(name="vl_livro")
	private float preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento")
	private Calendar dataLancamento;
	
	@Lob
	@Column(name="fl_capa")
	private byte[] capa;
	
	public Livro(String titulo, float preco, Calendar dataLancamento, byte[] capa) {
		super();
		this.titulo = titulo;
		this.preco = preco;
		this.dataLancamento = dataLancamento;
		this.capa = capa;
	}

	public Livro() {
		super();
		
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public byte[] getCapa() {
		return capa;
	}

	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
}
