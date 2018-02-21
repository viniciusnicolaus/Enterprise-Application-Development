package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Periodo;
import br.com.fiap.jpa.entity.Turma;
import br.com.fiap.jpa.entity.Unidade;

public class Teste2 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("2tdsa");

		EntityManager em = fabrica.createEntityManager();
		

		Turma turma = new Turma("2TDSA", 835, 50, false, null, 
				new GregorianCalendar(2018, Calendar.FEBRUARY, 5), Unidade.ACLIMAÇÃO, Periodo.MANHÃ);
		
		em.getTransaction().begin();
		em.persist(turma);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
