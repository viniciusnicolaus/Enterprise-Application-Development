package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public class MotoristaDAOTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		Motorista m = new Motorista(1, "Carlos", Calendar.getInstance(), null, Genero.MASCULINO);
		
		//Cadastar
		try {
			dao.cadastrar(m);
			dao.commit();
			System.out.println("Motorista cadastrado com sucesso");
		} catch (CommitException e) {
			System.err.println("Erro ao cadastar motorista");
		}
		
		//Consultar
		Motorista m2 = dao.buscar(2);
		System.out.println("Numero da carteira: " + m2.getNumeroCarteira());
		System.out.println("Nome motorista: " + m2.getNomeMotorista());
		System.out.println("Data: " + m2.getData());
		System.out.println("Genero" + m2.getGenero());
		
		//Modifica
		m2.setNomeMotorista("Vinicius");
		try {
			dao.atualizar(m2);
			dao.commit();
			System.out.println("Motorista atualizado com sucesso");
		} catch (CommitException e) {
			System.err.println("Erro ao atualizar");
		}
		
		//Remoçao
		try {
			dao.apagar(2);
			dao.commit();
			System.out.println("Motorista apagado com sucesso");
		} catch (RegistroNaoEncontradoException e) {
			System.err.println("Erro");
		}catch(CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
}
