package br.com.aula.dao;

import br.com.aula.model.Filme;

public interface FilmeDaoIF extends GenericDaoIF<Filme>{
	
	Filme buscarPorTitulo(String titulo);

}
