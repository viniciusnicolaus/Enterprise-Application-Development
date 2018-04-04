package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	List<Cliente> listar();
	
	List<Cliente> listarClientesPorEstado(String estado);

	List<Cliente> buscarPorDiasReserva(int dias);
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscar(String nome, String cidade);
	
}