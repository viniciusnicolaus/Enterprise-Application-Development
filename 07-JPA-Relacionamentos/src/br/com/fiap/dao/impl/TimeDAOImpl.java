package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.TimeDAO;
import br.com.fiap.jpa.entity.Time;

public class TimeDAOImpl extends GenericDAOImpl<Time, Integer> 
											implements TimeDAO{

	public TimeDAOImpl(EntityManager em) {
		super(em);
		
	}

}
