package br.com.fiap.nac.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.ProdutoDAO;
import br.com.fiap.nac.entity.Produto;

public class ProdutoDAOImpl extends GenericDAOImpl<Produto, Integer> implements ProdutoDAO {

	public ProdutoDAOImpl(EntityManager em) {
		super(em);
	
	}

	@Override
	public List<Produto> buscarPorDescricao(String desc) {
		return em.createQuery("from Produto p where p.descricao like :churros ", 
				Produto.class).setParameter("churros", "%"+desc+"%")
				.setMaxResults(50)
				.getResultList();
	}

}
