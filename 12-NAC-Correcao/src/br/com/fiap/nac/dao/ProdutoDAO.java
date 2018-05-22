package br.com.fiap.nac.dao;

import java.util.List;

import br.com.fiap.nac.entity.Produto;

public interface ProdutoDAO extends GenericDAO<Produto, Integer>{
	
	List<Produto> buscarPorDescricao(String desc);

}
