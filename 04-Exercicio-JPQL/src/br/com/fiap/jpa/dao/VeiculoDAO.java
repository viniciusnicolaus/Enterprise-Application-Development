package br.com.fiap.jpa.dao;

import java.util.List;

import br.com.fiap.jpa.entity.Veiculo;

public interface VeiculoDAO extends GenericDAO<Veiculo, Integer>{

	List<Veiculo> buscarPorAnoMinimo(int ano);
}

