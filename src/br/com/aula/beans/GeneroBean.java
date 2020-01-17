package br.com.aula.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.aula.entity.Genero;

@Named("generoBean")
@RequestScoped
public class GeneroBean {

	private Genero genero;
	
	@PostConstruct
	public void init() {
		genero = new Genero();
	}
	
	public void enviar() {
		System.out.println("Genero enviado: " + genero.getDescricaoGenero());
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
