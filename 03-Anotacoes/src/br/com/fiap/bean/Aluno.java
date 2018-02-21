package br.com.fiap.bean;

import br.com.fiap.anotation.Coluna;
import br.com.fiap.anotation.Tabela;
@Tabela(nome="TB_ALUNO")
public class Aluno {
	
	@Coluna(nome="cd_aluno")
	private int codigo;
	
	@Coluna(nome="nm_aluno")
	private String nome;

	public Aluno() {
		super();
	}

	public Aluno(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
