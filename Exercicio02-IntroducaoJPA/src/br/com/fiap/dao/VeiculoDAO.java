package br.com.fiap.dao;

import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public interface VeiculoDAO {
	
void cadastrar(Veiculo vel);
	
	Veiculo buscar(int codigo);
	
	void modificar(Veiculo vel);
	
	void apagar (int codigo) throws RegistroNaoEncontradoException;
	
	void commit() throws CommitException;
}
