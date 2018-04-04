package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class Exercicios {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Listar os Clientes
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		List<Cliente> lista = clienteDao.listar();
		//Exibir os clientes
		System.out.println("Listar Cliente");
		for (Cliente cliente : lista) {
			System.out.println(
					cliente.getNome() + " " +
					cliente.getCpf());
		}
		
		//Buscar de pacote por transporte
		System.out.println("Buscar por transpote");
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		
		Transporte transporte = transporteDao.pesquisar(1);
		List<Pacote> pacotes = pacoteDao.buscarPorPacote(transporte);
		
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		//Buscar cliente por estado
		System.out.println("Buscar cliente por estado");
		lista = clienteDao.listarClientesPorEstado("BA");
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		//Buscar por número de dias
		System.out.println("Buscar por número de dias");
		lista = clienteDao.buscarPorDiasReserva(10);
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		//Buscar Cliente por nome
		lista = clienteDao.buscarPorNome("a");
		System.out.println("Buscar Cliente Por Nomes");
		for(Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		em.close();
		fabrica.close();	
	}
}



