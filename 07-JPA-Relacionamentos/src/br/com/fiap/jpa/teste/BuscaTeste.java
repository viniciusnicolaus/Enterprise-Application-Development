package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.TecnicoDAOImpl;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.dao.TecnicoDAO;
import br.com.fiap.jpa.dao.TimeDAO;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		TimeDAO timeDao = new TimeDAOImpl(em);
		@SuppressWarnings("unused")
		TecnicoDAO tecnicoDao = new TecnicoDAOImpl(em);
		
		//Buscar o time
		Time time = timeDao.buscar(3);
		// exibir o nome do time
		System.out.println("Nome do time: " + time.getNome());		
		//exibir o nome do tecnico
		System.out.println("Nome do tecnico: " + time.getTecnico().getNome());
		
		em.close();
		fabrica.close();
	}

}
