package fr.backyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.backyard.dao.ProduitDao;
import fr.backyard.entities.Produit;


@SpringBootApplication
public class BackMicroserviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(BackMicroserviceApplication.class, args);
		ProduitDao produitDao = ctx.getBean(ProduitDao.class);
		Produit p1 = produitDao.save(new Produit(null, "LG", 250.00));
		Produit p2 = produitDao.save(new Produit(null, "Samsung", 500.00));
		Produit p3 = produitDao.save(new Produit(null, "Apple", 1000.99));
		Produit p4 = produitDao.save(new Produit(null, "Sony", 350.50));
		produitDao.findAll().forEach(p -> {
			System.out.println(p.getDesignation());
		});
	}

}
