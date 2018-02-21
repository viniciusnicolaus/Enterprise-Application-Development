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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_AUTOR")
@SequenceGenerator(name="autor",sequenceName="SQ_T_AUTOR",allocationSize=1)
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cd_id")
	@GeneratedValue(generator="autor",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nm_autor", nullable=false, length=300)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_sexo", nullable=false)
	private Sexo sexo;
	
	@Column(name="ds_sobrenome", nullable=false, length=300)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	public Autor() {
		super();
		
	}
	
	public Autor(String nome, Sexo sexo, String sobrenome, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
