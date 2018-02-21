package br.com.fiap.teste;

import br.com.fiap.anotation.Tabela;
import br.com.fiap.bean.Aluno;

public class Exercicio {
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno(2, "Bolinho");
		
		Tabela anotacao = aluno.getClass().getAnnotation(Tabela.class);
		System.out.println("SELECT * FROM " + anotacao.nome());
	}

}
