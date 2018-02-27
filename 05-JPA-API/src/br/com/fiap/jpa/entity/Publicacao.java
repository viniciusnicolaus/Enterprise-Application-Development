package br.com.fiap.jpa.entity;

import java.io.Serializable;
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
@Table(name="T_PUBLICACAO")
@SequenceGenerator(name="publicacao",sequenceName="SQ_T_POST",allocationSize=1) 
public class Publicacao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_publicacao")
	@GeneratedValue(generator="publicacao",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_autor", length=50, nullable=false)
	private String descricaoAutor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_publicacao",nullable=false)
	private Calendar dataPublicacao;
	
	@Lob
	@Column(name="fl_imagem")
	private byte[] imagem;
	
	@Column(name="ds_conteudo",length=250, nullable=false)
	private String descricaoConteudo;
	
	@Column(name="nr_curtida")
	private int numeroCurtidas;
	
	//@Enumerated(EnumType.STRING)
	@Column(name="ds_privacidade", nullable=false)
	private PrivacidadePublicacao privacidade;


	public Publicacao() {
		
	}

	public Publicacao(String descricaoAutor, Calendar dataPublicacao, byte[] imagem, String descricaoConteudo,
			int numeroCurtidas, PrivacidadePublicacao privacidade) {
		super();
		this.descricaoAutor = descricaoAutor;
		this.dataPublicacao = dataPublicacao;
		this.imagem = imagem;
		this.descricaoConteudo = descricaoConteudo;
		this.numeroCurtidas = numeroCurtidas;
		this.privacidade = privacidade;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}

	public void setDescricaoAutor(String descricaoAutor) {
		this.descricaoAutor = descricaoAutor;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getDescricaoConteudo() {
		return descricaoConteudo;
	}

	public void setDescricaoConteudo(String descricaoConteudo) {
		this.descricaoConteudo = descricaoConteudo;
	}

	public int getNumeroCurtidas() {
		return numeroCurtidas;
	}

	public void setNumeroCurtidas(int numeroCurtidas) {
		this.numeroCurtidas = numeroCurtidas;
	}

	public PrivacidadePublicacao getPrivacidade() {
		return privacidade;
	}

	public void setPrivacidade(PrivacidadePublicacao privacidade) {
		this.privacidade = privacidade;
	}
}
