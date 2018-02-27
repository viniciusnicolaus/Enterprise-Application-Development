package br.com.fiap.jpa.teste;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Publicacao;

public class BuscarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao publicacao = em.find(Publicacao.class, 1);
		
		System.out.println(publicacao.getDescricaoConteudo());
		System.out.println(publicacao.getDescricaoAutor());
		
		
		em.close();
		fabrica.close();
	}
}
