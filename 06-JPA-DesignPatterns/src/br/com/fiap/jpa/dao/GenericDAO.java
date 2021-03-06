package br.com.fiap.jpa.dao;

import br.com.fiap.exception.RegistradoNaoEncontradoException;
import br.com.fiap.jpa.exception.CommitException;

public interface GenericDAO <Tabela, Chave> {
	
	void cadastar(Tabela tabela);
	
	void atualiza(Tabela tabela);
	
	void excluir(Chave codigo) throws RegistradoNaoEncontradoException;
	
	Tabela buscar(Chave codigo);
	
	void commit() throws CommitException;

}
