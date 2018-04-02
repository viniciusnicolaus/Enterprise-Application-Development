package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.PlacaDAOImpl;
import br.com.fiap.jpa.dao.PlacaDAO;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Pais;
import br.com.fiap.jpa.entity.Placa;
import br.com.fiap.jpa.entity.Proprietario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Cadastro {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Proprietario p1 = new Proprietario("Paulo");
		
		PlacaDAO PlacaDao = new PlacaDAOImpl(em);
		
		Carro carro = new Carro(0123456, "Prata", 2007);
		Placa placa = new Placa(2020, Pais.BRASIL, carro);
		
		
		Carro c1 = new Carro(123, "preto", 1998);
		Carro c2 = new Carro(124, "Marrom", 2005);
		Carro c3 = new Carro(154, "Cinza", 2009);
		
		p1.adicionarCarro(c1);
		p1.adicionarCarro(c2);
		p1.adicionarCarro(c3);
		
		
		try {
			PlacaDao.cadastar(placa);
			PlacaDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
	}
}
