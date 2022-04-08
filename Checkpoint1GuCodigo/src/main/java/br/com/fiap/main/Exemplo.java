package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.TenisDao;
import br.com.fiap.dao.impl.TenisDaoImpl;
import br.com.fiap.entity.MarcaTenis;
import br.com.fiap.entity.Tenis;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Exemplo {
public static void main(String[] args) {
		
		//Obter uma fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um Tenis
		Tenis tenis = new Tenis("Air jordan 1", new GregorianCalendar(2020, Calendar.JULY, 16),"Court Purple",MarcaTenis.JORDAN,"Novo");
		
		//Instanciar um TenisDaoImpl
		TenisDao dao = new TenisDaoImpl(em);
		
		//Cadastrar
		try {
			dao.cadastrar(tenis);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			//Pesquisar pela PK
			Tenis busca = dao.pesquisar(1);
			//Exibir o nome
			System.out.println(busca.getNome());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Atualizar o nome do tenis
			tenis.setNome("Air jordan 1");
			dao.atualizar(tenis);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.remover(1);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
}
