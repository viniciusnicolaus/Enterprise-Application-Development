package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.entity.Cidade;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Listar as Cidades
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		List<Cidade> lista = cidadeDao.listar();
		//Exibir as cidades
		System.out.println("LISTAR CIDADES");
		for (Cidade cidade : lista) {
			System.out.println(
					cidade.getNome() + " " +
					cidade.getUf());
		}
		
		//Buscar por estado
		lista = cidadeDao.buscarPorEstado("SP");
		System.out.println("BUSCAR POR ESTADO");
		//Exibit as cidades
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		em.close();
		fabrica.close();	
	}
}



