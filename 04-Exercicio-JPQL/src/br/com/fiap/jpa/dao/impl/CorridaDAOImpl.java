package br.com.fiap.jpa.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO{

	public CorridaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Corrida> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Corrida c where c.data between :i and :f",Corrida.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.setMaxResults(30)
				.getResultList();
	}

	@Override
	public List<Corrida> buscarPorMotorista(Motorista motorista) {
		return em.createQuery("from Corrida c where c.motorista = :m",Corrida.class)
				.setParameter("m", motorista).getResultList();
	}

	@Override
	public long contarQuantidadePorPassageiro(int codigoPassageiro) {
		return em.createQuery("select count(c) from Corrida c where c.passageiro.codigo = :c",Long.class)
				.setParameter("c", codigoPassageiro).getSingleResult();
	}

	@Override
	public List<Corrida> buscarPorNomePassageiro(String nome) {
		return em.createQuery("from Corrida c where c.passageiro.nome like :n",Corrida.class)
				.setParameter("n", "%"+nome+"%").setMaxResults(40).getResultList();
	}

	@Override
	public long contarQuantidadePorMotoristaPeriodo(int codigoMotorista, Calendar inicio, Calendar fim) {
		return em.createQuery("select count(c) from Corrida c where c.motorista.numeroCarteira = :m and c.data between :i and :f",Long.class)
				.setParameter("m", codigoMotorista)
				.setParameter("i", inicio).setParameter("f" , fim).getSingleResult();
	}

	@Override
	public List<Corrida> buscarMaiorValorPorPassageiro(int codigoPassageiro) {
		return em.createQuery("from Corrida c where c.passageiro.codigo = :p order by c.valor",Corrida.class)
				.setParameter("p", codigoPassageiro).setMaxResults(10).getResultList();
	}

	@Override
	public List<Corrida> buscarPorPassageiroEMotorista(int codigoPassageiro, int numeroCarteira) {
		return em.createQuery("from Corrida c where c.passageiro.codigo = :p and c.motorista.numeroCarteira = :m",Corrida.class)
				.setParameter("p", codigoPassageiro).setParameter("m", numeroCarteira).getResultList();
	}


}
