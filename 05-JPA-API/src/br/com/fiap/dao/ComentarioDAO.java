package br.com.fiap.dao;

import br.com.fiap.jpa.entity.Comentario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public interface ComentarioDAO {

	void cadastrar(Comentario com);
	
	Comentario buscar(int codigo);
	
	void modificar(Comentario com);
	
	void apagar (int codigo) throws RegistroNaoEncontradoException;
	
	void commit() throws CommitException;
}
