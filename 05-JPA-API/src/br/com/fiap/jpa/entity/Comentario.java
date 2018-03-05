package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_COMENTARIO")
@SequenceGenerator(name="comentario", sequenceName="SQ_T_COMENTARIO", allocationSize=1)
public class Comentario {
	@Id
	@Column(name="cd_comentario")
	@GeneratedValue(generator= "comentario", strategy= GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_comentario", nullable=false)
	private Calendar dataComentario;
	
	@Column(name="ds_conteudo", length = 200, nullable=false)
	private String descricao;

	public Comentario() {
		super();
	}

	public Comentario(Calendar dataComentario, String descricao) {
		super();
		this.dataComentario = dataComentario;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Calendar dataComentario) {
		this.dataComentario = dataComentario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
