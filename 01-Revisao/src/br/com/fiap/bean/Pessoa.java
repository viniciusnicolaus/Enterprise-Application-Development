package br.com.fiap.bean;

public abstract class Pessoa {

	private String nome;

	public String caminhar() {
		return "Caminhando";
	}
	
	public abstract String correr();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
