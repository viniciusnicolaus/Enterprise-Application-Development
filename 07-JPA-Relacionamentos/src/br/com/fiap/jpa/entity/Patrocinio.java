package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.jpa.entity.Time;

@Entity
@Table(name="T_PATROCINIO")
@SequenceGenerator(name="patrocinio",sequenceName="SQ_T_PATROCINIO",allocationSize=1)
public class Patrocinio {
		
		@Id
		@Column(name="cd_patrocinio")
		@GeneratedValue(generator="patrocinio",strategy=GenerationType.SEQUENCE)
		private int codigo;
		
		@Column(name="nm_empresa",nullable=false)
		private String empresa;
		
		@Column(name="vl_patrocinio")
		private double valor;
		
		@ManyToMany(mappedBy="patrocinios")
		private List<Time> times;
		
		public List<Time> getTimes() {
			return times;
		}

		public void setTimes(List<Time> times) {
			this.times = times;
		}

		public Patrocinio() {
			
		}
		
		public Patrocinio(String empresa, double valor) {
			super();
			this.empresa = empresa;
			this.valor = valor;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getEmpresa() {
			return empresa;
		}

		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}
}
