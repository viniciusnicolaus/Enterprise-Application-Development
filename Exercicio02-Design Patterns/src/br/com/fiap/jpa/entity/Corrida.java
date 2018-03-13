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
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida", sequenceName="SQ_T_CORRIDA", allocationSize=1)
public class Corrida {
	
	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(generator="corrida", strategy=GenerationType.SEQUENCE)
	private int codigoCorrida;
	
	@Column(name="ds_origem", length=150)
	private String origem;
	
	@Column(name="ds_destino", length=150)
	private String destino;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_corrida")
	private Calendar dataCorrida;
	
	@Column(name="vl_corrida", nullable=false)
	private float valor;

	public Corrida() {
		
	}
	public Corrida(String origem, String destino, Calendar dataCorrida, float valor) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valor = valor;
	}
	public int getCodigoCorrida() {
		return codigoCorrida;
	}
	public void setCodigoCorrida(int codigoCorrida) {
		this.codigoCorrida = codigoCorrida;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Calendar getDataCorrida() {
		return dataCorrida;
	}
	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

}
