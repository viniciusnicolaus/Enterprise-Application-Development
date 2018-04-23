package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.ExemplarDAOImpl;
import br.com.fiap.jpa.CategoriaLivro;
import br.com.fiap.jpa.Exemplar;
import br.com.fiap.jpa.Livro;
import br.com.fiap.jpa.dao.ExemplarDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {
	public static void main(String[] args) throws CommitException {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ExemplarDAO dao = new ExemplarDAOImpl(em);
		Livro livro = new Livro(9874562, "O último estágiario", CategoriaLivro.BIOGRAFIA, 350);
		Exemplar exemplar = new Exemplar(1, Calendar.getInstance(), livro);
		
		dao.cadastar(exemplar);
		dao.commit();
		
		em.close();
		fabrica.close();
	}

}
