package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.EmpresaDAOImpl;
import br.com.fiap.exception.RegistradoNaoEncontradoException;
import br.com.fiap.jpa.dao.EmpresaDAO;
import br.com.fiap.jpa.entity.Empresa;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class EmpresaDAOTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
						EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		EmpresaDAO dao = new EmpresaDAOImpl(em);
		
		//Cadastro
		Empresa empresa = new Empresa("123", "FIAP", 500000);
		try {
			dao.cadastar(empresa);
			dao.commit();
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		//Buscar
		Empresa empresaBusca = dao.buscar("123");
		System.out.println("Cnpj: " + empresaBusca.getCnpj());
		System.out.println("Nome da empresa: " + empresaBusca.getNome());
		System.out.println("Faturamento: " + empresaBusca.getFaturamento());
		
		
		//Atualizar
		empresaBusca.setNome("FIAP-VILA-MARIANA");
		try {
			dao.atualiza(empresaBusca);
			dao.commit();
			System.out.println("Atualizado!");
		} catch (CommitException e) {
			System.out.println("Erro na atualização");
		}
		//Remover
		try {
			dao.excluir("123");
			dao.commit();
			System.out.println("Apagado com sucesso");
		} catch (RegistradoNaoEncontradoException e) {
			System.err.println("Erro ao deletar");
		} catch (CommitException e ) {
			e.printStackTrace();
		}
	
		em.close();
		fabrica.close();	
	}
}
