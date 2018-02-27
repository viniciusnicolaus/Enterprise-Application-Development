package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.PrivacidadePublicacao;
import br.com.fiap.jpa.entity.Publicacao;

public class CadastrarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("2tdsa");
		
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao publicacao = new Publicacao(
				"Vinícius Nicolau", 
				new GregorianCalendar(2018, Calendar.FEBRUARY, 27), 
				null, 
				"Aprendi a usar o github", 
				17, 
				PrivacidadePublicacao.PUBLICO);
		
		
		em.getTransaction().begin();		
		em.persist(publicacao);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
	}

}
