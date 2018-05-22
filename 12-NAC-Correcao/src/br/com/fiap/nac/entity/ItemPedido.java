package br.com.fiap.nac.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="NAC_ITEM_PEDIDO")
@SequenceGenerator(name="itemPedido", sequenceName="SEQ_NAC_ITEM_PEDIDO", allocationSize=1)
public class ItemPedido {

	@Id
	@GeneratedValue(generator="itemPedido", strategy=GenerationType.SEQUENCE)
	private int codigo;

	@Column(nullable=false)
	private int quantidade; 
	
	@Column(name="valor_item", nullable=false)
	private float valor;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="pedido_codigo")
	private Pedido pedido;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="produto_codigo")
	private Produto produto;

	
	public ItemPedido() {
		super();
	}

	public ItemPedido(int quantidade, float valor, Pedido pedido, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.valor = valor;
		this.pedido = pedido;
		this.produto = produto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
