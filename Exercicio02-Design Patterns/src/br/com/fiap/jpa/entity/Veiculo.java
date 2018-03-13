package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName="SQ_T_VEICULO", allocationSize=1)
public class Veiculo {
	
	@Id
	@Column(name="cd_veiculo")
	@GeneratedValue(generator="veiculo", strategy = GenerationType.SEQUENCE)
	private int codigo; //cd_veiculo *
	
	@Column(name="ds_placa", length = 9, nullable = false)
	private String descricaoPlaca; //varchar9 ds_placa *
	@Column(name="ds_cor", length=20, nullable=false)
	private String descricaoCor; //varchar20 ds_cor	*
	@Column(name="nr_ano")
	private int numeroAno;	//nr_ano
	
	public Veiculo() {
		
	}
	public Veiculo(String descricaoPlaca, String descricaoCor, int numeroAno) {
		super();
		this.descricaoPlaca = descricaoPlaca;
		this.descricaoCor = descricaoCor;
		this.numeroAno = numeroAno;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricaoPlaca() {
		return descricaoPlaca;
	}
	public void setDescricaoPlaca(String descricaoPlaca) {
		this.descricaoPlaca = descricaoPlaca;
	}
	public String getDescricaoCor() {
		return descricaoCor;
	}
	public void setDescricaoCor(String descricaoCor) {
		this.descricaoCor = descricaoCor;
	}
	public int getNumeroAno() {
		return numeroAno;
	}
	public void setNumeroAno(int numeroAno) {
		this.numeroAno = numeroAno;
	}
}
