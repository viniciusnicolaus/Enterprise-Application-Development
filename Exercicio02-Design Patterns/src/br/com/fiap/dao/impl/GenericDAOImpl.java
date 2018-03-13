package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public abstract class GenericDAOImpl <Tabela, Chave> 
					implements GenericDAO<Tabela, Chave> {

	private EntityManager em;
	
	//ARMAZENA O .CLASS DA TABELA em.find
	private Class<Tabela> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		
		//Cast recuperando os parametros
		clazz = (Class<Tabela>)
			((ParameterizedType)
				getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
	}

	@Override
	public void cadastar(Tabela tabela) {
		em.persist(tabela);
	}

	@Override
	public void atualiza(Tabela tabela) {
		em.merge(tabela);
	}

	@Override
	public void excluir(Chave codigo) throws RegistroNaoEncontradoException {
		Tabela t = buscar(codigo);
		if(t == null) 
			throw new RegistroNaoEncontradoException("Registro não encontrado");
			em.remove(t);	
	}

	@Override
	public Tabela buscar(Chave codigo) {
		
		return em.find(clazz, codigo);
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

