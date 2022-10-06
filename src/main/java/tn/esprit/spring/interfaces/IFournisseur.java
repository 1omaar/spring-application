package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Fournisseur;

import java.util.List;

public interface IFournisseur {
    public List<Fournisseur> retrieveAllFournisseurs();
    public Fournisseur addFournisseur (Fournisseur f);
    public Fournisseur updateFournisseur (Fournisseur f);
    public Fournisseur retrieveFournisseur (Long id);
}
