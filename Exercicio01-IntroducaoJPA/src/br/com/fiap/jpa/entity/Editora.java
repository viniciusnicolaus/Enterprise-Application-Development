package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_EDITORA")
@SequenceGenerator(name="editora",sequenceName="SQ_T_EDITORA",allocationSize=1)
public class Editora implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cd_id")
	@GeneratedValue(generator="editora",strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="ds_cnpj", nullable=false, length=100)
	private String cnpj;
	
	@Column(name="ds_nome", nullable=false, length=300)
	private String nome;
	
	@Column(name="ds_endereco", nullable=false, length=400)
	private String endereco;
	

	public Editora(String cnpj, String nome, String endereco) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}

	public Editora() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
