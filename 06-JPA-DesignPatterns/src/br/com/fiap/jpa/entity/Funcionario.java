package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="T_FUNCIONARIO")
@SequenceGenerator(name="funcionario", sequenceName="SQ_T_FUNCIONARIO",allocationSize=1)
public class Funcionario {
	
	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator="funcionario", strategy=GenerationType.SEQUENCE)
	private int codigo; // cd_funcionario (fk)
	
	@Column(name="nm_funcionario", length=100, nullable=false)
	private String nome; //nm_funcionario (length =100)

	@Column(name="ds_cargo", length=20)
	private String descricao; // ds_cargo (length =20)

	public Funcionario() {
		
	}
	public Funcionario(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
