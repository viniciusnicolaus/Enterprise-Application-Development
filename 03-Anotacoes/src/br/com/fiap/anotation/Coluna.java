package br.com.fiap.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Anotação fica presente até a execução
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //Anotação é aplicada somente para atributos
public @interface Coluna {
	

	String nome();	

}
