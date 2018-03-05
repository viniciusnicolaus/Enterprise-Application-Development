package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ComentarioDAO;
import br.com.fiap.jpa.entity.Comentario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public class ComentarioDAOImpl implements ComentarioDAO {

	private EntityManager em;
	
	public ComentarioDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void cadastrar(Comentario com) {
		em.persist(com);
		
	}

	@Override
	public Comentario buscar(int codigo) {
		return em.find(Comentario.class, 1);
	}

	@Override
	public void modificar(Comentario com) {
		em.merge(com);
		
	}

	@Override
	public void apagar(int codigo) throws RegistroNaoEncontradoException {
		Comentario c = buscar(codigo);
		if(c == null)
			throw new RegistroNaoEncontradoException("Comentário não encontrado");
		em.remove(c);
		
	}

	@Override
	public void commit() throws CommitException {
		try {	
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if(em.getTransaction().isActive())
			   em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
		  }
	}

}
