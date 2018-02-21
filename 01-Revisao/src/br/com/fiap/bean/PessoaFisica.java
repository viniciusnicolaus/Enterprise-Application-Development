package br.com.fiap.bean;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Estudante, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String correr() {
		return "Correndo";
	}

	@Override
	public void estudar() {
		System.out.println("Estudando");
	}

	@Override
	public void fazerProvas() {
		System.out.println("Gabaritando");
	}

}
