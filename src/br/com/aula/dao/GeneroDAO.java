package br.com.aula.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.aula.model.Genero;
import br.com.aula.util.JPAFactory;

public class GeneroDAO  implements GeneroDaoIF, Serializable {

	private static final long serialVersionUID = -317012148029573847L;
	
	private EntityManager em = null;
	
	@Override
	public void inserir(Genero objeto) {
		em = JPAFactory.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(objeto);
		
		em.getTransaction().commit();
		
		JPAFactory.close(em);
		
	}

	@Override
	public void atualizar(Genero objeto) {
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
		
		Genero genero = buscarPorId(id);
		em.remove(genero);
		
		em.getTransaction().commit();
		
		JPAFactory.close(em);
		
	}

	@Override
	public List<Genero> buscarTodos() {
		List<Genero> generos = new ArrayList<Genero>();
		
		em = JPAFactory.getEntityManager();
		
		String jpql = "SELECT a FROM Genero a";
		
		TypedQuery<Genero> query = em.createQuery(jpql, Genero.class);
		
		generos = query.getResultList();
		
		return generos;
	}

	@Override
	public Genero buscarPorId(Long id) {
		em = JPAFactory.getEntityManager();
		
		Genero genero = em.find(Genero.class, id);
		
		return genero;
	}

	@Override
	public Genero buscarPorDescricao(String descricao) {
		Genero genero = null;
		
		em = JPAFactory.getEntityManager();
		
		String jpql = "SELECT a FROM Genero a WHERE a.descricaoGenero = :descricao";
		
		TypedQuery<Genero> query = em.createQuery(jpql, Genero.class);
		query.setParameter("descricao", descricao);
		
		try {
			genero = query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return genero;
	}

}
