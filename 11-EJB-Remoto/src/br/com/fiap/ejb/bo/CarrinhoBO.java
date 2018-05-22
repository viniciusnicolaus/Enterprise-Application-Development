package br.com.fiap.ejb.bo;

import java.util.List;
import javax.ejb.Local;

@Local
public interface CarrinhoBO {

	void adicionarItem(String item);
	
	List<String> listarItens();
	
}
