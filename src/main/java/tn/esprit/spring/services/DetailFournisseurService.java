package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.DetailFournisseur;
import tn.esprit.spring.interfaces.IDetailFournisseur;
import tn.esprit.spring.repositories.IDetailFournisseurRepository;

@Service
public class DetailFournisseurService implements IDetailFournisseur {
    @Autowired
    IDetailFournisseurRepository detailFournisseurRepository;
    @Override
    public DetailFournisseur addDetailFournisseur(DetailFournisseur f) {
        return detailFournisseurRepository.save(f);
    }
}
