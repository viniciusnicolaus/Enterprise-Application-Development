package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.Exemplar;
import br.com.fiap.jpa.ExemplarPK;
import br.com.fiap.jpa.dao.ExemplarDAO;

public class ExemplarDAOImpl extends GenericDAOImpl<Exemplar, ExemplarPK>
															implements ExemplarDAO {

	public ExemplarDAOImpl(EntityManager em) {
		super(em);
	}
	

}
