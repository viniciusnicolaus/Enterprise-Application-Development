package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_TECNICO")
@SequenceGenerator(name="tecnico", sequenceName="SQ_T_TECNICO",allocationSize=1)
public class Tecnico {

	@Id
	@Column(name="cd_tecnico")
	@GeneratedValue(generator="tecnico", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_tecnico", nullable=false, length=100 )
	private String nome;
	
	@Column(name="st_capacitado")
	private boolean capacitacao;
	
	//Quando a relação é bidimensional voce coloca o mappedBy, pra nao criar a chave
	@OneToOne(mappedBy="tecnico")
	private Time time;

	public Tecnico() {
		
	}
	
	public Tecnico(String nome, boolean capacitacao) {
		super();
		this.nome = nome;
		this.capacitacao = capacitacao;
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

	public boolean isCapacitacao() {
		return capacitacao;
	}

	public void setCapacitacao(boolean capacitacao) {
		this.capacitacao = capacitacao;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
