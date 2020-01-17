package br.com.aula.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.aula.entity.Ator;
import br.com.aula.entity.Filme;
import br.com.aula.entity.Genero;

@Named("filmeBean")
@RequestScoped
public class FilmeBean {

	private Filme filme;

	@PostConstruct
	public void init() {
		filme = new Filme();
		inicializaAtor();
		inicializaGenero();
	}
	
	private void inicializaAtor() {
		List<Ator> atores = new ArrayList<>();
		Ator ator = new Ator();
		ator.setEmail("teste@br.com");
		ator.setNome("Meu nome");
		atores.add(ator);
		filme.setAtores(atores);
	}
	
	private void inicializaGenero() {
		List<Genero> generos = new ArrayList<>();
		Genero genero = new Genero();
		genero.setDescricaoGenero("Filme de acao");
		generos.add(genero);
		filme.setGeneros(generos);
	}
	
	public void enviar() {
		System.out.println("Filme enviado: " + filme.getTitulo());
	}
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	
}
