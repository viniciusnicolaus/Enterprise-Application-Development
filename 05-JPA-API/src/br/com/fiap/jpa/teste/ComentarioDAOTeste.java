package br.com.fiap.jpa.teste;


import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.ComentarioDAO;
import br.com.fiap.dao.impl.ComentarioDAOImpl;
import br.com.fiap.jpa.entity.Comentario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public class ComentarioDAOTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("2tdsa");

		EntityManager em = 
				fabrica.createEntityManager();

		ComentarioDAO dao = new ComentarioDAOImpl(em);

		Comentario c = new Comentario(Calendar.getInstance(), "Exercício de JPA");
		try {
			dao.cadastrar(c);
			dao.commit();
			System.out.println("Comentário cadastrado");
		} catch (CommitException e) {
			System.out.println("Erro");
		}

		//Buscar
		Comentario c2 = dao.buscar(2);
		System.out.println(c2.getDataComentario());
		System.out.println(c2.getDescricao());

		//Atualizar
		c2.setDescricao("JPA EXERCÍCIO FINALIZADO");
		try {
			dao.modificar(c2);
			dao.commit();
			System.out.println("Atualizado!");
		} catch (CommitException e) {
			System.out.println("Erro");
		}

		//Remover
		try {
			dao.apagar(2);
			dao.commit();
			System.out.println("Comentário apagado");
		}catch(RegistroNaoEncontradoException e) {
			System.out.println("Comentário não encontrado");
		} catch (CommitException e) {
			e.printStackTrace();
		}

		em.close();
		fabrica.close();
	}
}
