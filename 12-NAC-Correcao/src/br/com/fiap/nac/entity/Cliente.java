package br.com.fiap.nac.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="NAC_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SEQ_NAC_CLIENTE", allocationSize=1)
public class Cliente {
	
	@Id
	@GeneratedValue(generator="cliente", strategy=GenerationType.SEQUENCE)
	
	private int codigo;
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false, length=15)
	private String cpf;
	
	private Sexo sexo;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	
	
	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, Sexo sexo, List<Pedido> pedidos) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.pedidos = pedidos;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
