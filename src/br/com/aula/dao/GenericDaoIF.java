package br.com.aula.dao;

import java.util.List;

public interface GenericDaoIF <T> {
	
	void inserir(T objeto);
	void atualizar(T objeto);
	void remover(Long id);
	List<T> buscarTodos();
	T buscarPorId(Long id);

}
