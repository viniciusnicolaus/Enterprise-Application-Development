package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.EmpresaDAO;
import br.com.fiap.jpa.entity.Empresa;

public class EmpresaDAOImpl
				extends GenericDAOImpl<Empresa, String>
									implements EmpresaDAO{

	public EmpresaDAOImpl(EntityManager em) {
		super(em);
		
	}
}
