package br.com.aula.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aula.dao.FilmeDAO;
import br.com.aula.model.Filme;

@Named("filmeBean")
@ViewScoped
public class FilmeBean implements Serializable {

	private static final long serialVersionUID = 7114499294303993268L;
	
	@Inject
	private Filme filme;
	@Inject
	private FilmeDAO filmeDAO;
	
	private List<Filme> filmes;

	@PostConstruct
	public void init() {
		filmes = new ArrayList<>();
	}
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public void cadastrarFilme() {
		filmeDAO.inserir(filme);
		
		FacesMessage message = new FacesMessage("Filme " + filme.getTitulo() + " Cadastrado com Sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		filme = new Filme();
	}
	
	public void listarTodos() {
		filmes = filmeDAO.buscarTodos();
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}
	
	public void excluir(Long idFilme) {
		filmeDAO.remover(idFilme);
	}
}
