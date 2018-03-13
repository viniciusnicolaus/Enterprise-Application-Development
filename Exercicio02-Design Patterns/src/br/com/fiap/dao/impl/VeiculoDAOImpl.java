package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;


import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public class VeiculoDAOImpl implements VeiculoDAO{

	private EntityManager em;
	
	
	public VeiculoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void cadastrar(Veiculo vel) {
		em.persist(vel);
		
	}

	@Override
	public Veiculo buscar(int codigo) {
		return em.find(Veiculo.class, 1);
	}

	@Override
	public void modificar(Veiculo vel) {
		em.merge(vel);
		
	}

	@Override
	public void apagar(int codigo) throws RegistroNaoEncontradoException {
		Veiculo v = buscar(codigo);
		if(v == null)
			throw new RegistroNaoEncontradoException("Veiculo nao encontrado");
		em.remove(v);
		
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao realizar commit");
		}
	}
}
