package br.com.fiap.nac.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="NAC_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName="SEQ_NAC_PEDIDO", allocationSize=1)
public class Pedido {
	
	@Id
	@GeneratedValue(generator="pedido", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cliente_codigo")
	private Cliente cliente;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itens;
	
	public Pedido() {
		
	}
	
	public Pedido(Calendar data, Cliente cliente, List<ItemPedido> itens) {
		super();
		this.data = data;
		this.cliente = cliente;
		this.itens = itens;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItemPedido() {
		return itens;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itens = itemPedido;
	}
}
