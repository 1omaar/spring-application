package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.SecteurActivite;

import java.util.List;

public interface ISecteurActivite {
   public  List<SecteurActivite> retrieveAllSecteurActivites();

   public SecteurActivite addSecteurActivite (SecteurActivite sa);

   public SecteurActivite updateSecteurActivite (SecteurActivite sa);

   public SecteurActivite retrieveSecteurActivite (Long id);

   public void removeSecteurActivite (Long id);
   public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long
           secteurActiviteId) ;
}
