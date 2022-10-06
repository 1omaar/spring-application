package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.interfaces.ICategorieProduit;
import tn.esprit.spring.interfaces.IProduit;
import tn.esprit.spring.interfaces.IStock;
import tn.esprit.spring.repositories.ICategorieProduitRepository;
import tn.esprit.spring.repositories.IProduitrepository;
import tn.esprit.spring.repositories.IStockRepository;

import java.util.List;
@Service
public class ProduitService implements IProduit {
    @Autowired
    IProduitrepository produitrepository;
    @Autowired
    ICategorieProduit cat;
    @Autowired
    IStock stock;

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitrepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
        CategorieProduit c = cat.retrieveCategorieProduit(idCategorieProduit);
        Stock s = stock.retrieveStock(idStock);
        System.out.println(s);
        p.setCategorieProduit(c);
        p.setStock(s);
        return produitrepository.save(p);
    }

    @Override
    public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {
        CategorieProduit c = cat.retrieveCategorieProduit(idCategorieProduit);
        Stock s = stock.retrieveStock(idStock);
        System.out.println(s);
        p.setCategorieProduit(c);
        p.setStock(s);
        return produitrepository.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitrepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = retrieveProduit(idProduit);
        Stock s = stock.retrieveStock(idStock);
        p.setStock(s);
        produitrepository.save(p);
    }
}
