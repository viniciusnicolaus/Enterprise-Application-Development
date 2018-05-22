package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	long contarTotal();
	
	List<Cliente> listar();
	
	List<Cliente> listarClientesPorEstado(String estado);

	List<Cliente> buscarPorDiasReserva(int dias);
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
	//Contar a quantidade de cliente por estado
	long contarPorEstado(String uf);
	
	List<Cliente> buscarPorMaiorReserva();
}