package br.com.fiap.dao;

import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public interface MotoristaDAO {
	
	void cadastrar(Motorista mot);
	
	Motorista buscar(int codigo);
	
	void atualizar(Motorista mot);
	
	void apagar(int codigo) throws RegistroNaoEncontradoException;
	
	void commit() throws CommitException;
}
