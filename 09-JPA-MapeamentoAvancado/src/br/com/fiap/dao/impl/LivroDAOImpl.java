package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.Livro;
import br.com.fiap.jpa.dao.LivroDAO;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Long>
													implements LivroDAO{

	public LivroDAOImpl(EntityManager em) {
		super(em);
		
	}

}
