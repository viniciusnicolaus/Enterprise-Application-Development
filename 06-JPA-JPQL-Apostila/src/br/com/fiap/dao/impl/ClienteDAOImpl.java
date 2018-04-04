package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		return em.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}

	@Override
	public List<Cliente> listarClientesPorEstado(String estado) {
		return em.createQuery("from Cliente where endereco.cidade.uf = :estado",
				Cliente.class).setParameter("estado", estado).getResultList();
	}
	
	@Override
	public List<Cliente> buscarPorDiasReserva(int dias){
		return em.createQuery("select cliente from Reserva r where r.numeroDias =:d",
				Cliente.class).setParameter("d",dias).getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		
		return em.createQuery(
				"from Cliente where nome like :n",
				Cliente.class).setParameter("n", "%"+nome+"%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliete c where ", Cliente.class)
				.setParameter("n", "%"++"%");
	}



}







