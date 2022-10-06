package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Produit;

import java.util.List;

public interface IProduit {
    public List<Produit> retrieveAllProduits();

   public Produit addProduit (Produit p, Long idCategorieProduit, Long idStock);

   public Produit updateProduit (Produit p, Long idCategorieProduit, Long idStock);

   public Produit retrieveProduit(Long id);

   public void assignProduitToStock(Long idProduit, Long idStock);
}
