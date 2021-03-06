package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PagamentoDAO;
import br.com.fiap.dao.impl.PagamentoDAOImpl;
import br.com.fiap.jpa.entity.FormaPagamento;
import br.com.fiap.jpa.entity.Pagamento;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class PagamentoDAOTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar
		PagamentoDAO dao = new PagamentoDAOImpl(em);
		
		Pagamento p = new Pagamento(new GregorianCalendar(2018, Calendar.MARCH, 12), 250, FormaPagamento.DEBITO);
		try {
			dao.cadastar(p);
			dao.commit();
			System.out.println("Cadastrado com sucesso");
		} catch (CommitException e) {
			System.err.println("Erro ao cadastrar");
		}
		
		//Buscar
		Pagamento p2 = dao.buscar(15);
		
		System.out.println("Data: " + p2.getDataPagamento());
		System.out.println("Valor: " + p2.getValorPagamento());
		System.out.println("Forma Pagamento: " + p2.getDescricaoFormaPagamento());
		
		//Atualizar
		
		p2.setValorPagamento(300);
		try {
			dao.atualiza(p2);
			dao.commit();
			System.out.println("Atualizado com sucesso");
		} catch (CommitException e) {
			System.err.println("Erro ao atualizar");
		}
		
		//Apagar
		try {
			dao.excluir(15);
			dao.commit();
			System.out.println("Apagado com sucesso");
		} catch (RegistroNaoEncontradoException e) {
			System.err.println("Registro nao encontrado");
		}catch(CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
		
	}
}
