package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	List<Pacote> buscarPorPacote(Transporte transporte);
	
	List<Pacote> buscarPorData(Calendar inicio, Calendar fim);
	
	double calcularMediaPreco();
	double calcularMediaPacote();
}
