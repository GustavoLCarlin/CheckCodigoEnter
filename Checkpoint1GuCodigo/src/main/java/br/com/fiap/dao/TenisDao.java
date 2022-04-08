package br.com.fiap.dao;

import br.com.fiap.entity.Tenis;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface TenisDao {
	
	Tenis pesquisar(Integer id) throws IdNotFoundException;
	
	void cadastrar(Tenis tenis);
	
	void atualizar(Tenis tenis) throws IdNotFoundException;
	
	void remover(Integer id) throws IdNotFoundException;
	
	void commit() throws CommitException;

}
