package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{
	float contarPorCliente(Cliente cliente);
}
