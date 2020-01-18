package br.com.aula.dao;

import br.com.aula.model.Ator;

public interface AtorDaoIF extends GenericDaoIF<Ator> {
	
	Ator buscarPorNome(String nome);

}
