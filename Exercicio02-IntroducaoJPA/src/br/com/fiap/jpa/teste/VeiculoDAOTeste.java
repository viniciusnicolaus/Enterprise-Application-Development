package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.dao.impl.VeiculoDAOImpl;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public class VeiculoDAOTeste {
	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();

		VeiculoDAO dao = new VeiculoDAOImpl(em);

		Veiculo v = new Veiculo("ABC-SP", "Prata", 2000);

		// Cadastar
		try {
			dao.cadastrar(v);
			dao.commit();
			System.out.println("Veiculo cadastrado com sucesso");
		} catch (CommitException e) {
			System.err.println("Erro ao cadastrar");
		}

		//Buscar
		Veiculo v2 = dao.buscar(2);
		System.out.println("Descriçao placa: " + v2.getDescricaoPlaca());
		System.out.println("Descriçao cor: " + v2.getDescricaoCor());
		System.out.println("Ano do carro: " + v2.getNumeroAno());

		//Atualizar
		v2.setDescricaoCor("Preto");
		try {
			dao.modificar(v2);
			dao.commit();
			System.out.println("Veiculo atualizado");
		} catch (CommitException e) {
			System.err.println("Erro ao atualizar");
		}

		//Excluir
		try {
			dao.apagar(2);
			dao.commit();
			System.out.println("Veiculo deletado com sucesso");
		}catch(RegistroNaoEncontradoException e) {
			System.err.println("Veiculo nao encontrado");
		}catch (CommitException e) {
			e.printStackTrace();
		}

		em.close();
		fabrica.close();


	}
}
