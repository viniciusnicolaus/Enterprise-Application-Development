package br.com.fiap.jpa.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.jpa.entity.Corrida;
import br.com.fiap.jpa.entity.Motorista;

public interface CorridaDAO extends GenericDAO<Corrida, Integer>{

	List<Corrida> buscarPorDatas(Calendar inicio, Calendar fim);
	
	List<Corrida> buscarPorMotorista(Motorista motorista);
	
	long contarQuantidadePorPassageiro(int codigoPassageiro);
	
	List<Corrida> buscarPorNomePassageiro(String nome);
	
	long contarQuantidadePorMotoristaPeriodo(int numeroCarteira, Calendar inicio, Calendar fim);
	
	List<Corrida> buscarMaiorValorPorPassageiro(int codigoPassageiro);
	
	List<Corrida> buscarPorPassageiroEMotorista(int codigoPassageiro, int numeroCarteira);
	
}
