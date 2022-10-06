package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Facture;

import java.util.List;

public interface IFacture {
   public List<Facture> retrieveAllFactures();
   public void cancelFacture(Long id);
   public Facture retrieveFacture(Long id);
   public void assignOperateurToFacture(Long idOperateur, Long idFacture);

   public List<Facture> getFacturesByfournisseur(Long idFournisseur);

   public Facture addFacture(Facture f,Long idFournisseur);
}
