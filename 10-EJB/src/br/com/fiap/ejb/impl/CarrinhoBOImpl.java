package br.com.fiap.ejb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.com.fiap.ejb.bo.CarrinhoBO;

@Stateful
public class CarrinhoBOImpl implements CarrinhoBO{

	private List<String> lista = new ArrayList<String>();
	
	@Override
	public void adicionarItem(String item) {
		lista.add(item);
	}

	@Override
	public List<String> listarItens() {
		
		return lista;
	}

}
