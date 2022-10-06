package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.interfaces.IDetailFournisseur;
import tn.esprit.spring.interfaces.IFournisseur;
import tn.esprit.spring.repositories.IFournisseurRepository;

import java.util.List;
@Service
public class FournisseurService implements IFournisseur {
    @Autowired
    IFournisseurRepository fournisseurRepository;
    @Autowired
    IDetailFournisseur detailFournisseurServices;
    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        detailFournisseurServices.addDetailFournisseur(f.getDetailFournisseur());
        return fournisseurRepository.save(f);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        return fournisseurRepository.save(f);
    }

    @Override
    public Fournisseur retrieveFournisseur(Long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }
}
