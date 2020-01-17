package br.com.aula.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.aula.entity.Ator;

@Named
@RequestScoped
public class AtorBean {

	private Ator ator;

	@PostConstruct
	public void init() {
		ator = new Ator();
	}
	
	public void enviar() {
		System.out.println("Ator enviado: " + ator.getNome());
	}
	
	public Ator getAtor() {
		return ator;
	}
	public void setAtor(Ator ator) {
		this.ator = ator;
	}
	
}
