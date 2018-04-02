package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="T_TIME")
@SequenceGenerator(name="time",sequenceName="SQ_T_TIME",allocationSize=1)
public class Time {
	
	@Id
	@Column(name="cd_codigo")
	@GeneratedValue(generator="time",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_time", nullable=false, length=50)
	private String nome;
	
	@Column(name="nr_socios")
	private long numeroSocios;
	
	
	@OneToOne(fetch= FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="cd_tecnico")
	private Tecnico tecnico;
	
	@OneToMany(mappedBy="time", cascade=CascadeType.PERSIST)
	private List<Jogador> jogadores = new ArrayList<>();
	
	//Apenas no OneToMany
	public void adicionarJogador(Jogador jogador) {
		jogadores.add(jogador);//adiciona na lista
		jogador.setTime(this);//seta o time do jogador
	}

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(	name="T_PATROCINIO_TIME",
				joinColumns= @JoinColumn(name="cd_time"), 
				inverseJoinColumns=@JoinColumn(name="cd_patrocinio"))
	private List<Patrocinio> patrocinios;
	public Time() {
		
	}
	
	public Time(String nome, long numeroSocios, Tecnico tecnico) {
		super();
		this.nome = nome;
		this.numeroSocios = numeroSocios;
		this.tecnico = tecnico;
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

	public long getNumeroSocios() {
		return numeroSocios;
	}

	public void setNumeroSocios(long numeroSocios) {
		this.numeroSocios = numeroSocios;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Patrocinio> getPatrocinios() {
		return patrocinios;
	}

	public void setPatrocinios(List<Patrocinio> patrocinios) {
		this.patrocinios = patrocinios;
	}
	
}
