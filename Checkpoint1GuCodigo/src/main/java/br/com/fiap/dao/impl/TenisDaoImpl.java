package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TenisDao;
import br.com.fiap.entity.Tenis;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public class TenisDaoImpl implements TenisDao {

private EntityManager em;
	
	public TenisDaoImpl(EntityManager em) {
		this.em = em;
	}

	public Tenis pesquisar(Integer id) throws IdNotFoundException {
		//Pesquisar o tenis no banco
		Tenis tenis = em.find(Tenis.class, id);
		//Validar se o tenis não existe (se é igual null)
		if (tenis == null)
			//Se existir, lançar uma exception
			throw new IdNotFoundException(); 
		//Se não existir, Retorna a musica
		return tenis;
	}

	public void cadastrar(Tenis tenis) {
		em.persist(tenis);
	}

	public void atualizar(Tenis tenis) throws IdNotFoundException {
		//validar se o tenis existe no banco, para ser atualizado
		pesquisar(tenis.getId()); 
		em.merge(tenis);
	}

	public void remover(Integer id) throws IdNotFoundException {
		Tenis tenis = pesquisar(id);
		em.remove(tenis);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
}
