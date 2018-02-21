package br.com.fiap.teste;

import br.com.fiap.bean.Escolaridade;

public class EnumTeste {

	public static void main(String[] args) {

		Escolaridade e = Escolaridade.FUNDAMENTAL_COMPLETO;
		if(e == Escolaridade.FUNDAMENTAL_COMPLETO) 
		{
			System.out.println(e);
		}
	}

}
