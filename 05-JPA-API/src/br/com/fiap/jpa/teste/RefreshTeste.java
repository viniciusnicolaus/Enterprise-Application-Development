package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Publicacao;

public class RefreshTeste {
	public static void main(String[] args) {
		// Criar Entity Manage
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar uma publicacao
		Publicacao p = em.find(Publicacao.class, 1);
		
		//Exibir o conteudo
		System.out.println(p.getDescricaoConteudo());
		
		//Alterar o conteúdo da publicacao no java
		p.setDescricaoConteudo("Aprendi github, git e gitignore");
		
		//Exibir o conteúdo
		System.out.println(p.getDescricaoConteudo());
		
		//Refresh
		em.refresh(p);
		
		//Exibir o conteúdo
		System.out.println(p.getDescricaoConteudo());
		
		em.close();
		fabrica.close();
	}
}
