package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Periodo;
import br.com.fiap.jpa.entity.Turma;
import br.com.fiap.jpa.entity.Unidade;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("2tdsa");

		EntityManager em = fabrica.createEntityManager();

		Aluno aluno = new Aluno("Juninho", 
				new GregorianCalendar(2017, Calendar.JANUARY,2),
				false, 0, "2TDSA", 2, Genero.MASCULINO, 1500, null);
		Turma turma = new Turma("2TDSA", 835, 50, false, null, 
				new GregorianCalendar(2018, Calendar.FEBRUARY, 5), 
				Unidade.ACLIMAÇÃO, Periodo.MANHÃ);
		
		
		em.getTransaction().begin();
		em.persist(aluno); // Insert
		em.persist(turma);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
