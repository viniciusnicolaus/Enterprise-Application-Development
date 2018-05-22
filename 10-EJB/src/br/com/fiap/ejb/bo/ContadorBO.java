package br.com.fiap.ejb.bo;

import javax.ejb.Local;

@Local
public interface ContadorBO {

	void incrementar();
	
	int verTotal();
}
