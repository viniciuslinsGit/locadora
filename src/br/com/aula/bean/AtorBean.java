package br.com.aula.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aula.dao.AtorDAO;
import br.com.aula.model.Ator;

@Named("atorBean")
@ViewScoped
public class AtorBean implements Serializable {

	private static final long serialVersionUID = 5104889562220218832L;

	@Inject
	private Ator ator;
	@Inject
	private AtorDAO atorDAO;
	
	private List<Ator> atores;
	
	@PostConstruct
	public void init() {
		atores = atorDAO.buscarTodos();
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public void cadastrarAtor() {
		atorDAO.inserir(ator);
		
		FacesMessage message = new FacesMessage("Ator " + ator.getNome() + " Cadastrado com Sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		ator = new Ator();
	}

	public List<Ator> getAtores() {
		return atores;
	}
	
}
