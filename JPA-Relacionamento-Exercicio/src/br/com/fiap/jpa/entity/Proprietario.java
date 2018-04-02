package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PROPRIETARIO")
@SequenceGenerator(name="proprietario", sequenceName="SQ_T_PROPRIETARIO", allocationSize=1)
public class Proprietario {
	
	@Id
	@Column(name="cd_proprietario")
	@GeneratedValue(generator="proprietario",strategy=GenerationType.SEQUENCE)
	private int codProp;
	
	@Column(name="nm_proprietario",nullable=false, length=100)
	private String nome;
	
	@OneToMany(mappedBy="proprietario", cascade=CascadeType.PERSIST)
	private List<Carro> carros = new ArrayList<>();
	
	public void adicionarCarro(Carro carro) {
		carros.add(carro);//adiciona na lista
		carro.setProprietario(this);//seta o time do jogador
	}

	
	public Proprietario(String nome) {
		super();
		this.nome = nome;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public Proprietario() {
		
	}

	public int getCodProp() {
		return codProp;
	}

	public void setCodProp(int codProp) {
		this.codProp = codProp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
