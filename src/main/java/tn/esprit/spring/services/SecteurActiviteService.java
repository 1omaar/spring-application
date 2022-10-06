package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.SecteurActivite;
import tn.esprit.spring.interfaces.IFournisseur;
import tn.esprit.spring.interfaces.ISecteurActivite;
import tn.esprit.spring.repositories.ISecteurActiviteRepository;

import java.util.List;
@Service
public class SecteurActiviteService implements ISecteurActivite {
    @Autowired
    ISecteurActiviteRepository secteurActiviteRepository;
    @Autowired
    IFournisseur fournisseurServices;
    @Override
    public List<SecteurActivite> retrieveAllSecteurActivites() {
        return secteurActiviteRepository.findAll();
    }

    @Override
    public SecteurActivite addSecteurActivite(SecteurActivite sa) {
        return secteurActiviteRepository.save(sa);
    }

    @Override
    public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
        return secteurActiviteRepository.save(sa);
    }

    @Override
    public SecteurActivite retrieveSecteurActivite(Long id) {
        return secteurActiviteRepository.findById(id).orElse(null);
    }

    @Override
    public void removeSecteurActivite(Long id) {
    secteurActiviteRepository.deleteById(id);
    }

    @Override
    public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) {
        SecteurActivite sa = retrieveSecteurActivite(secteurActiviteId);
        Fournisseur f= fournisseurServices.retrieveFournisseur(fournisseurId);
        sa.getFournisseurs().add(f);
        secteurActiviteRepository.save(sa);
    }
}
