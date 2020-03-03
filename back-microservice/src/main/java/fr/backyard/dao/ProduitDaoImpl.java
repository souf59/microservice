package fr.backyard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.backyard.entities.Produit;

;

@Repository
@Transactional
public class ProduitDaoImpl implements ProduitDao {
	@PersistenceContext
	private EntityManager entityManager;

	public ProduitDaoImpl() {

	}

	@Override
	public Produit save(Produit p) {
		entityManager.persist(p);
		return p;
	}

	@Override
	public List<Produit> findAll() {
		Query req = entityManager.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@Override
	public Produit findOne(Long id) {
		Produit p = entityManager.find(Produit.class, id);
		return p;
	}

	@Override
	public void delete(Long id) {
		Produit p = entityManager.find(Produit.class, id);
		entityManager.remove(p);
	}

	@Override
	public Produit update(Produit p) {
		 entityManager.merge(p);
		 return p;

	}

	@Override
	public List<Produit> findByDesignation(String mc) {
		Query req= entityManager.createQuery("select p from Produit p where p.designation like : x");
		req.setParameter("x", mc);
		return req.getResultList();
	}
}

