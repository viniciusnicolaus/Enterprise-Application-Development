package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.ItemPedidoDAO;
import br.com.fiap.nac.entity.ItemPedido;

public class ItemPedidoDAOImpl extends GenericDAOImpl<ItemPedido, Integer> implements ItemPedidoDAO{

	public ItemPedidoDAOImpl(EntityManager em) {
		super(em);
		
	}

}
