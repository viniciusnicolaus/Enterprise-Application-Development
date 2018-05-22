package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<Pacote> buscarPorPacote(Transporte transporte) {
		TypedQuery<Pacote> query = em.createQuery( 
				"from Pacote p where p.transporte = :t",Pacote.class);
		query.setParameter("t", transporte);
		
		return query.getResultList();
		
		/*return em.createQuery(  
				"from Pacote where transporte = :t",
				Pacote.class).setParameter("t", transporte).getResultList();*/
	}

	@Override
	public List<Pacote> buscarPorData(Calendar inicio, Calendar fim) {
		
		return em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

	@Override
	public double calcularMediaPreco() {
		
		return em.createQuery("select avg(p.preco) from Pacote p", Double.class).getSingleResult();
	}

	@Override
	public double calcularMediaPacote() {
		
		return em.createQuery("select avg(p) from Pacote p", Double.class).getSingleResult();
	}
	
}
