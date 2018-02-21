package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import br.com.fiap.anotation.Coluna;
import br.com.fiap.bean.Aluno;

public class ColunaTeste {
	public static void main(String[] args) {
		//Instanciar um aluno
		
		Aluno aluno = new Aluno(1, "Dollynho");
		
		//API de Reflection -> estrutura da classe
		//Recuperar o nome da classe
		String classe = aluno.getClass().getName();
		System.out.println(classe);
		
		//Recuperar os m�todos 
		Method[] metodos = aluno.getClass().getDeclaredMethods();
		for (Method method : metodos) {
			//Exibe os nomes dos m�todos
			System.out.println(method.getName());
		}
		
		//Recuperar
		Field[] atributos = aluno.getClass().getDeclaredFields();
		for (Field field : atributos) {
			//Exibe o nome dos atributos
			System.out.println(field.getName());
			//Recuperar a anota��oo @Coluna
			Coluna anotacao = field.getAnnotation(Coluna.class);
			System.out.println(anotacao.nome());
		}
		
	}
}
