package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cidade> listar() {
		//Criar a query
		TypedQuery<Cidade> query = em.createQuery(
				"from Cidade",Cidade.class);
		//Executar a query
		return query.getResultList();
	}

	@Override
	public List<Cidade> buscarPorEstado(String estado) {
		//Criar a query
		TypedQuery<Cidade> query = em.createQuery(
				"from Cidade where uf = :churros",Cidade.class);
		//Passar o parametro para a query
		query.setParameter("churros", estado);
		//Executar a query
		return query.getResultList();
	}

}
