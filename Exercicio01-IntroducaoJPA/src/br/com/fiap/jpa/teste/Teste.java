package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Autor;
import br.com.fiap.jpa.entity.Editora;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.entity.Sexo;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("2tdsa");

		EntityManager em = fabrica.createEntityManager();

		Editora editora = new Editora("02618290", "Editora Trevo", "R. Delmar Soares, 65 - Vila Pedra Branca, São Paulo - SP");
		
		Livro livro = new Livro("Percy Jackson: O Ladrão de raios", 100, new GregorianCalendar(2010,Calendar.FEBRUARY,12), null);
		
		Autor autor = new Autor("Rick", Sexo.MASCULINO, "Riordan", new GregorianCalendar(1964, Calendar.JUNE, 5));
		
		
		em.getTransaction().begin();
		em.persist(editora);
		em.persist(livro);
		em.persist(autor);
		em.getTransaction().commit();
		
		
		em.close();
		fabrica.close();
	}
}
