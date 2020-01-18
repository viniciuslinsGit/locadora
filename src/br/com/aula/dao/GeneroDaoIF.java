package br.com.aula.dao;

import br.com.aula.model.Genero;

public interface GeneroDaoIF extends GenericDaoIF<Genero> {
	
	Genero buscarPorDescricao(String matricula);

}
