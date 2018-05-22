package br.com.fiap.jsf.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.ejb.bo.CarrinhoBO;

@ManagedBean
@SessionScoped
public class CarrinhoBean {
	
	private List<String> itens;
	private String item;
	
	@EJB
	private CarrinhoBO bo;
	
	public void adicionar() {
		bo.adicionarItem(item);
		itens = bo.listarItens();
	}
	
	public List<String> getItens() {
		return itens;
	}
	public void setItens(List<String> itens) {
		this.itens = itens;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
}
