package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.PrivacidadePublicacao;
import br.com.fiap.jpa.entity.Publicacao;

public class AtualizarTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao p = //em.find(Publicacao.class, 1);
						new Publicacao("Vinicius", 
								new GregorianCalendar(2018, Calendar.FEBRUARY, 27), 
								null, 
								"Aprendi github e git", 
								65, 
								PrivacidadePublicacao.PUBLICO);
		p.setCodigo(1);
		//p.setDescricaoAutor("VinizinDaZn");
		//p.setNumeroCurtidas(60);
		
		em.merge(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
	}
}
