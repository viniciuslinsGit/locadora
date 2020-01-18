package br.com.aula.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.aula.model.Filme;
import br.com.aula.util.JPAFactory;

public class FilmeDAO implements FilmeDaoIF, Serializable {
	
	private static final long serialVersionUID = -7647958845409554793L;

	private EntityManager em = null;
	
	@Override
	public void inserir(Filme objeto) {
		em = JPAFactory.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(objeto);
		
		em.getTransaction().commit();
		
		JPAFactory.close(em);
		
	}

	@Override
	public void atualizar(Filme objeto) {
		em = JPAFactory.getEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(objeto);
		
		em.getTransaction().commit();
		
		JPAFactory.close(em);
		
	}

	@Override
	public void remover(Long id) {
		em = JPAFactory.getEntityManager();
		
		em.getTransaction().begin();
		
		Filme filme = buscarPorId(id);
		em.remove(filme);
		
		em.getTransaction().commit();
		
		JPAFactory.close(em);
		
	}

	@Override
	public List<Filme> buscarTodos() {
		List<Filme> filmes = new ArrayList<Filme>();
		
		em = JPAFactory.getEntityManager();
		
		String jpql = "SELECT d FROM Filme d";
		
		TypedQuery<Filme> query = em.createQuery(jpql, Filme.class);
		
		filmes = query.getResultList();
		
		return filmes;
	}

	@Override
	public Filme buscarPorId(Long id) {
		em = JPAFactory.getEntityManager();
		
		Filme filme = em.find(Filme.class, id);
		
		return filme;
	}

	@Override
	public Filme buscarPorTitulo(String titulo) {
		Filme filme = null;
		
		em = JPAFactory.getEntityManager();
		
		String jpql = "SELECT d FROM Filme d WHERE d.titulo = :titulo";
		
		TypedQuery<Filme> query = em.createQuery(jpql, Filme.class);
		query.setParameter("titulo", titulo);
		
		try {
			filme = query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return filme;
	}

}
