package br.com.fiap.ejb.impl;

import java.util.Calendar;
import javax.ejb.Stateless;
import br.com.fiap.ejb.bo.ClienteBO;

@Stateless
public class ClienteBOImpl implements ClienteBO {

	@Override
	public int calcularIdade(Calendar dataNascimento) {
		Calendar atual = Calendar.getInstance();
		int anoAtual = atual.get(Calendar.YEAR);
		int mesAtual = atual.get(Calendar.MONTH);
		int diaAtual = atual.get(Calendar.DAY_OF_MONTH);
		
		int anoNasc = dataNascimento.get(Calendar.YEAR);
		int mesNasc = dataNascimento.get(Calendar.MONTH);
		int diaNasc = dataNascimento.get(Calendar.DAY_OF_MONTH);
		
		int idade = anoAtual - anoNasc;
		
		if (mesNasc > mesAtual || (mesNasc == mesAtual && diaNasc > diaAtual)) {
			idade--;
		}
	
		return idade;
	}
	
}
