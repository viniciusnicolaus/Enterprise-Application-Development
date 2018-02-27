package br.com.fiap.dao;

import br.com.fiap.jpa.entity.Publicacao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public interface PublicacaoDAO {
	
	void cadastrar(Publicacao pub);
	
	Publicacao buscar(int codigo);
	
	void modificar(Publicacao pub);
	
	void apagar (int codigo) throws RegistroNaoEncontradoException;
	
	void commit() throws CommitException;

}
