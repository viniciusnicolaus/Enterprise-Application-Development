package br.com.fiap.ejb.bo;

import java.util.Calendar;

import javax.ejb.Remote;

@Remote
public interface ClienteBO {
	
	int calcularIdade(Calendar dataNascimento);

}
