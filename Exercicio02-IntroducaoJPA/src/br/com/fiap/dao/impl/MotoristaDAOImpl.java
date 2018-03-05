package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

	public class MotoristaDAOImpl implements MotoristaDAO{

		private EntityManager em;
	
		public MotoristaDAOImpl(EntityManager em) {
			super();
			this.em = em;
		}

		@Override
		public void cadastrar(Motorista mot) {
			em.persist(mot);
			
		}

		@Override
		public Motorista buscar(int codigo) {
			return em.find(Motorista.class, 1);
		}

		@Override
		public void atualizar(Motorista mot) {
			em.merge(mot);
			
		}

		@Override
		public void apagar(int codigo) throws RegistroNaoEncontradoException {
			Motorista m = buscar(codigo);
			if(m == null)
				throw new RegistroNaoEncontradoException("Motorista nao encontrado");
			em.remove(m);	
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
