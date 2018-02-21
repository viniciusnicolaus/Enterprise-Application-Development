package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_TURMA")
@SequenceGenerator(name="turma",sequenceName="SQ_T_TURMA",allocationSize=1)
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_turma")
	@GeneratedValue(generator="turma",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_turma", nullable=false, length=100)
	private String nome;
	
	@Column(name="vl_turma", nullable=false)
	private float valor;
	
	@Column(name="nr_total_vaga", nullable=false)
	private int numeroVaga;
	
	@Column(name="st_ead", nullable=false)
	private boolean statusEad;
	
	@Lob
	@Column(name="fl_grade")
	private byte[] grade;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_criacao")
	private Calendar dataCriacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_unidade")
	private Unidade unidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_periodo")
	private Periodo periodo;
	
	public Turma(String nome, float valor, int numeroVaga, boolean statusEad, byte[] grade, Calendar dataCriacao,
			Unidade unidade, Periodo periodo) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.numeroVaga = numeroVaga;
		this.statusEad = statusEad;
		this.grade = grade;
		this.dataCriacao = dataCriacao;
		this.unidade = unidade;
		this.periodo = periodo;
	}

	public Turma() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public boolean isStatusEad() {
		return statusEad;
	}

	public void setStatusEad(boolean statusEad) {
		this.statusEad = statusEad;
	}

	public byte[] getGrade() {
		return grade;
	}

	public void setGrade(byte[] grade) {
		this.grade = grade;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}
