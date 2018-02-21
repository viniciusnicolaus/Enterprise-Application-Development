package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;

public class Teste {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(
				1, 12, Calendar.getInstance(), 10, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(
				1, 17, Calendar.getInstance(), 150, 2);
		
		List<ContaCorrente> lista = new ArrayList<ContaCorrente>();
			
		ContaCorrente cc1 = new ContaCorrente(
				1, 14, Calendar.getInstance(), 25, TipoConta.ESPECIAL);
		ContaCorrente cc2 = new ContaCorrente(
				1, 15, Calendar.getInstance(), 100, TipoConta.PREMIUM);
				
		lista.add(cc);
		lista.add(cc1);
		lista.add(cc2);
		
		for (ContaCorrente contaCorrente : lista) {
			System.out.println(contaCorrente.getSaldo());
			
		}
	}
}
