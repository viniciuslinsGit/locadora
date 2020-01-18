package br.com.aula.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.aula.model.Ator;
import br.com.aula.util.JPAFactory;

public class AtorDAO  implements AtorDaoIF, Serializable {

	private static final long serialVersionUID = -317012148029573847L;
	
	private EntityManager em = null;
	
	@Override
	public void inserir(Ator objeto) {
		em = JPAFactory.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(objeto);
		
		em.getTransaction().commit();
		
		JPAFactory.close(em);
		
	}

	@Override
	public void atualizar(Ator objeto) {
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
		
		Ator ator = buscarPorId(id);
		em.remove(ator);
		
		em.getTransaction().commit();
		
		JPAFactory.close(em);
		
	}

	@Override
	public List<Ator> buscarTodos() {
		List<Ator> ators = new ArrayList<Ator>();
		
		em = JPAFactory.getEntityManager();
		
		String jpql = "SELECT a FROM Ator a";
		
		TypedQuery<Ator> query = em.createQuery(jpql, Ator.class);
		
		ators = query.getResultList();
		
		return ators;
	}

	@Override
	public Ator buscarPorId(Long id) {
		em = JPAFactory.getEntityManager();
		
		Ator ator = em.find(Ator.class, id);
		
		return ator;
	}

	@Override
	public Ator buscarPorNome(String nome) {
		Ator ator = null;
		
		em = JPAFactory.getEntityManager();
		
		String jpql = "SELECT a FROM Ator a WHERE a.nome = :nome";
		
		TypedQuery<Ator> query = em.createQuery(jpql, Ator.class);
		query.setParameter("nome", nome);
		
		try {
			ator = query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ator;
	}

}
