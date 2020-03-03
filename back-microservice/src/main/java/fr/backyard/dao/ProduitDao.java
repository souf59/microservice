package fr.backyard.dao;

import java.util.List;

import fr.backyard.entities.Produit;


public interface ProduitDao {
	public Produit save(Produit p);

	public List<Produit> findAll();

	public Produit findOne(Long id);

	public void delete(Long id);

	public Produit update(Produit p);
	
	public List<Produit> findByDesignation(String mc);
}
