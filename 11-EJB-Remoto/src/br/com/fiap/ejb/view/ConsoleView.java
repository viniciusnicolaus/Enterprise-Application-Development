package br.com.fiap.ejb.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.ejb.bo.ClienteBO;

public class ConsoleView {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		//Inicializa o contexo com as propriedades configuradas
		try {
			Context contexto = new InitialContext(prop);
			
			//Recuperar o objeto remoto para acessar o EJB
			ClienteBO bo = (ClienteBO) contexto.lookup("ejb:/10-EJB/ClienteBOImpl!br.com.fiap.ejb.bo.ClienteBO");
			
			int idade = bo.calcularIdade(new GregorianCalendar(1999, Calendar.JUNE, 13));
			
			System.out.println(idade);
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}

}
