package br.com.fiap.jsf.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.ejb.bo.ClienteBO;

@ManagedBean
public class ClienteBean {
	
	private Calendar nascimento;
	private int idade;
	
	@EJB
	private ClienteBO bo;
	
	//Inicializar a data! Sempre precisa
	@PostConstruct
	private void init() {
		nascimento = Calendar.getInstance();
	}
	
	public void calcular() {
		idade = bo.calcularIdade(nascimento);
	}
	
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
