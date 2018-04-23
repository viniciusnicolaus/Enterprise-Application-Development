package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.dao.PagamentoDAO;
import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.dao.impl.CorridaDAOImpl;
import br.com.fiap.jpa.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.dao.impl.PagamentoDAOImpl;
import br.com.fiap.jpa.dao.impl.VeiculoDAOImpl;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
	
		MotoristaDAO motoristaDao = new MotoristaDAOImpl(em);
		CorridaDAO corridaDao = new CorridaDAOImpl(em);
		VeiculoDAO veiculoDao = new VeiculoDAOImpl(em);
		PagamentoDAO pagamentoDao = new PagamentoDAOImpl(em);
		
		//EX 01
		List<Motorista> motoristas = motoristaDao.buscarPorNome("a");
		System.out.println("EX 01");
		for (Motorista motorista : motoristas) {
			System.out.println(motorista.getNome());
		}
		
		//EX 02
		Calendar inicio = new GregorianCalendar(2018,Calendar.JANUARY,1);
		Calendar fim = new GregorianCalendar(2018,Calendar.DECEMBER,31);
		List<Corrida> corridas = corridaDao.buscarPorDatas(inicio, fim);
		System.out.println("EX 02");
		for (Corrida corrida : corridas) {
			System.out.println(corrida.getDestino());
		}
		
		//EX 03
		List<Veiculo> veiculos = veiculoDao.buscarPorAnoMinimo(2018);
		System.out.println("EX 03");
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getAno());
		}
		
		//EX 04
		Motorista motorista = motoristaDao.buscar(1);
		corridas = corridaDao.buscarPorMotorista(motorista);
		System.out.println("EX 04");
		for (Motorista m : motoristas) {
			System.out.println(m.getNome());
		}
		
		//EX 05
		System.out.println("EX 05");
		System.out.println("Corridas: " + corridaDao.contarQuantidadePorPassageiro(1));
		
		//EX 06
		corridas = corridaDao.buscarPorNomePassageiro("a");
		System.out.println("EX 06");
		for (Corrida corrida : corridas) {
			System.out.println(corrida.getPassageiro().getNome());
		}
		
		//EX 07
		System.out.println("EX 07");
		System.out.println("Valor Total: " + pagamentoDao.somarPagamentoPorPassageiro(1));
		
		//EX 08
		System.out.println("EX 08");
		System.out.println("Total corridas: " + corridaDao.contarQuantidadePorMotoristaPeriodo(1, inicio, fim));
		
		//EX 09
		corridas = corridaDao.buscarMaiorValorPorPassageiro(1);
		System.out.println("EX 09");
		for (Corrida corrida : corridas) {
			System.out.println(corrida.getPassageiro().getNome() + " " + corrida.getValor());
		}
		
		//EX 10
		corridas = corridaDao.buscarPorPassageiroEMotorista(1, 1);
		System.out.println("EX 10");
		for (Corrida corrida : corridas) {
			System.out.println(corrida.getPassageiro().getNome() + " " + corrida.getMotorista().getNome());
		}
		
		em.close();
		fabrica.close();
	}
	
}
