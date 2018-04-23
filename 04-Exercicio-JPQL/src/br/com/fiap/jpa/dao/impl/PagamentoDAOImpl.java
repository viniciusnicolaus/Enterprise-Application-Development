package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.PagamentoDAO;
import br.com.fiap.jpa.entity.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Integer> implements PagamentoDAO{

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public double somarPagamentoPorPassageiro(int codigoPassageiro) {
		return em.createQuery("select sum(p.valor) from Pagamento p where p.corrida.passageiro.codigo = :p",Double.class)
				.setParameter("p", codigoPassageiro)
				.getSingleResult();
	}

}
