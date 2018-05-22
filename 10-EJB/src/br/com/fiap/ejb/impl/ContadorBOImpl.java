package br.com.fiap.ejb.impl;

import javax.ejb.Singleton;
import br.com.fiap.ejb.bo.ContadorBO;

@Singleton
public class ContadorBOImpl implements ContadorBO{

	private int total;
	
	@Override
	public void incrementar() {
		total++;
	}

	@Override
	public int verTotal() {
		return total;
	}

}
