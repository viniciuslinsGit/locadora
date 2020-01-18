package br.com.aula.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aula.dao.GeneroDAO;
import br.com.aula.model.Genero;

@Named("generoBean")
@ViewScoped
public class GeneroBean implements Serializable {

	private static final long serialVersionUID = 1573755080544271151L;
	
	@Inject
	private Genero genero;
	@Inject
	private GeneroDAO generoDAO;
	
	private List<Genero> generos;
	
	@PostConstruct
	public void init() {
		generos = generoDAO.buscarTodos();
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void cadastrarGenero() {
		generoDAO.inserir(genero);
		
		FacesMessage message = new FacesMessage("Genero " + genero.getDescricaoGenero() + " Cadastrado com Sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);

		genero = new Genero();
	}

	public List<Genero> getGeneros() {
		return generos;
	}
	
}
