package br.com.fiap.nac.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.nac.dao.ItemPedidoDAO;
import br.com.fiap.nac.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.nac.entity.Cliente;
import br.com.fiap.nac.entity.ItemPedido;
import br.com.fiap.nac.entity.Pedido;
import br.com.fiap.nac.entity.Produto;
import br.com.fiap.nac.entity.Sexo;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Cliente cliente = new Cliente("Vinícius", "47488842820", Sexo.MASCULINO, null);
		Produto produto = new Produto("Pizza", "Queijo", null, null);
		Pedido pedido = new Pedido(Calendar.getInstance(), cliente, null);
		ItemPedido item = new ItemPedido(1, 5, pedido, produto);
		
		ItemPedidoDAO dao = new ItemPedidoDAOImpl(em);
		
		try {
			dao.cadastrar(item);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		em.close();
		fabrica.close();
	}

}
