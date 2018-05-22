package br.com.fiap.nac.dao;

import br.com.fiap.nac.entity.Pedido;

public interface PedidoDAO extends GenericDAO<Pedido, Integer>{

	long contarPorCliente(int codigoCliente);
	
}
