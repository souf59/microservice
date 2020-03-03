package fr.backyard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.backyard.dao.ProduitDao;
import fr.backyard.entities.Produit;


@RestController
@RequestMapping("/rest")
public class ProduitController {
	@Autowired
	private ProduitDao produitDao;

	@GetMapping("/list")
	public List<Produit> getAll() {
		return produitDao.findAll();
	}

	@GetMapping("/show/{id}")
	public Produit getOne(@PathVariable(name = "id") Long id) {
		return produitDao.findOne(id);
	}

	@PostMapping("/add")
	public Produit save(@RequestBody Produit produit) {
		return produitDao.save(produit);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		produitDao.delete(id);
	}

	@PutMapping("/update")
	public Produit update(@RequestBody Produit produit) {
		return produitDao.update(produit);

	}
	 
	@GetMapping(value="/cherchermc")
	public List<Produit> searchParMC(@RequestParam(name="mc", defaultValue="") String mc){
		return produitDao.findByDesignation("%"+mc+"%");
		
	}
	

}