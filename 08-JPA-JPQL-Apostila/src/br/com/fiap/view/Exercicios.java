package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
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
		
		lista = clienteDao.buscarPorNome("thiago");
		System.out.println("Buscar Cliente Por Nomes");
		for(Cliente cliente : lista) {
			System.out.println(cliente.getNome());
		}
		
		
		//Buscar Pacotes por data de saida
		System.out.println("Buscar Pacotes por data de saida");
		Calendar inicio = new GregorianCalendar(2015,Calendar.MAY,2);
		Calendar fim = new GregorianCalendar(2018,Calendar.MAY,2);
		
		pacotes = pacoteDao.buscarPorData(inicio, fim);
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		//Buscar cliente por nome e cidade
		lista = clienteDao.buscar("ã", "a");
		System.out.println("Buscar cliente por nome e cidade");
		for (Cliente cliente : lista) {
			System.out.println(cliente.getNome() + " - " 
		+ cliente.getEndereco().getCidade().getNome());
			
		}
		
		//Buscar clientes passados como parâmetro na Collection(List)
		List<String> estados = new ArrayList<>();
		estados.add("SP");
		estados.add("RJ");
		estados.add("BA");
		estados.add("TO");
		estados.add("RR");
		estados.add("GO");
		
		lista = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar cliente por estados");
		for (Cliente c : lista) {
			System.out.println(c.getNome() + " - " + c.getEndereco().getCidade().getUf());
			
		}
		
		//Listar os transportes (Genetic DAO)
		List<Transporte> transportes = transporteDao.listar();
		System.out.println("Listar Transportes (Generic DAO)");
		for (Transporte t : transportes) {
			System.out.println(t.getEmpresa());
		}
		
		//Retorna soma de clientes
		System.out.println("Cliente: " + clienteDao.contarTotal());
		//Retorna a média dos preços do pacote
		System.out.println("Média dos preços: " + pacoteDao.calcularMediaPreco());
		//Retorna a media dos pacotes
		System.out.println("Média dos pacotes: " + pacoteDao.calcularMediaPacote());
		//Contar por estado
		System.out.println("Cliente de SP: " + clienteDao.contarPorEstado("SP"));
		
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		//Contar a quantidade de reserva por cliente
		System.out.println("Contar por cliente: " + 
						reservaDao.contarPorCliente(clienteDao.pesquisar(2)));
		em.close();
		fabrica.close();	
	}
}



