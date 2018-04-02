package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.dao.impl.CorridaDAOImpl;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.FormaPagamento;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.entity.Pagamento;
import br.com.fiap.jpa.entity.Passageiro;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
	
		Corrida corrida = new Corrida("FIAP Aclimação", "FIAP Paulista", Calendar.getInstance(), 10);
		
		Passageiro passageiro = new Passageiro("Joaozinho", new GregorianCalendar(1999, Calendar.JANUARY, 2), Genero.MASCULINO);
		
		Motorista motorista = new Motorista(123, "Aninha", new GregorianCalendar(1990, Calendar.JANUARY, 2), null, Genero.FEMININO);
		
		Pagamento pagamento = new Pagamento(Calendar.getInstance(), 10, FormaPagamento.DINHEIRO);
		
		Veiculo veiculo1 = new Veiculo("AAA8965", "Branco", 2010);
		Veiculo veiculo2 = new Veiculo("BBB9099", "Azul", 2015);
		
		corrida.setMotorista(motorista);
		corrida.setPassageiro(passageiro);
		
		corrida.setPagamento(pagamento); //mappedBy precisa setar o outro lado para a cascata
		pagamento.setCorrida(corrida);
		
		List<Veiculo> veiculos = new ArrayList<>();
		veiculos.add(veiculo1);
		veiculos.add(veiculo2);
		
		motorista.setVeiculos(veiculos);
		
		CorridaDAO dao = new CorridaDAOImpl(em);
		
		try {
			dao.cadastrar(corrida); //cadastra todas as entidades por cascata
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}
