package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.TecnicoDAOImpl;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.dao.TecnicoDAO;
import br.com.fiap.jpa.dao.TimeDAO;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Patrocinio;
import br.com.fiap.jpa.entity.Posicao;
import br.com.fiap.jpa.entity.Tecnico;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		TimeDAO timeDao = new TimeDAOImpl(em);
		TecnicoDAO tecnicoDao = new TecnicoDAOImpl(em);
		
		
		//Cadastro o time, o tecnico e os jogadores
		
		Tecnico tecnico = new Tecnico("Tite", true);
		Time time = new Time("Seleção Brasileira", 207000000, tecnico);
		
		Jogador j1 = new Jogador("Paulinho", 800000, Posicao.VOLANTE);
		Jogador j2 = new Jogador("Neymar", 8000000, Posicao.ATACANTE);
		Jogador j3 = new Jogador("Philippe Coutinho", 750000 , Posicao.MEIA);
		
		time.adicionarJogador(j1);
		time.adicionarJogador(j2);
		time.adicionarJogador(j3);
		
		Patrocinio p1 = new Patrocinio("RIOT", 50000);
		Patrocinio p2 = new Patrocinio("VALVE", 100000);
		Patrocinio p3 = new Patrocinio("STEAM", 500000);
		
		List<Patrocinio> patrocinios = new ArrayList<>();
		patrocinios.add(p1);
		patrocinios.add(p2);
		patrocinios.add(p3);
		
		time.setPatrocinios(patrocinios);
		
		try {
			timeDao.cadastar(time);
			timeDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
}
