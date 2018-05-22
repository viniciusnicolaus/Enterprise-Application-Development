package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public float contarPorCliente(Cliente cliente) {
		
		return em.createNamedQuery("Reserva.contarQuantidade",Long.class)
				.setParameter("c", cliente)
				.getSingleResult();
	}

}
