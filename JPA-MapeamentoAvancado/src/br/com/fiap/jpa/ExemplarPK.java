package br.com.fiap.jpa;

import java.io.Serializable;

public class ExemplarPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numero;
	
	private long livro;
	
	public ExemplarPK() {
		
	}

	public ExemplarPK(int numero, long livro) {
		super();
		this.numero = numero;
		this.livro = livro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public long getLivro() {
		return livro;
	}

	public void setLivro(long livro) {
		this.livro = livro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (livro ^ (livro >>> 32));
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExemplarPK other = (ExemplarPK) obj;
		if (livro != other.livro)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	

}
