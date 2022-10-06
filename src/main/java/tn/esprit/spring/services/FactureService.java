package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.DetailFacture;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Operateur;
import tn.esprit.spring.interfaces.IFacture;
import tn.esprit.spring.interfaces.IFournisseur;
import tn.esprit.spring.interfaces.IOperateur;
import tn.esprit.spring.repositories.IDetailFactureRepository;
import tn.esprit.spring.repositories.IDetailFournisseurRepository;
import tn.esprit.spring.repositories.IFactureRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FactureService implements IFacture {
    @Autowired
    IFactureRepository factureRepository;
    @Autowired
    IOperateur operateurServices;
    @Autowired
    IFournisseur fournisseurService;
    @Autowired
    IDetailFactureRepository detailFactureRepository;
    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        Facture f = retrieveFacture(id);
        f.setArchive(true);
        factureRepository.save(f);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @Override
    public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
        Operateur o=operateurServices.retrieveOperateur(idOperateur);
        Facture f=retrieveFacture(idFacture);
        o.getFactures().add(f);
        operateurServices.addOperateur(o);
    }

    @Override
    public List<Facture> getFacturesByfournisseur(Long idFournisseur) {
        return  factureRepository.findByFournisseur_IdFournisseur(idFournisseur);
    }

    @Override
    public Facture addFacture(Facture f, Long idFournisseur) {
        Fournisseur fournisseur =  fournisseurService.retrieveFournisseur(idFournisseur);

        f.setFournisseur(fournisseur);

        return factureRepository.save(addDetailFacture(f));

    }
     private Facture addDetailFacture (Facture f){
        Set<DetailFacture> detailFactureList= new HashSet<>();
        detailFactureList.addAll(f.getDetailFactures());
        float montantRemiseFacture = 0;
         for (DetailFacture df:detailFactureList) {
             float montantRemise = (df.getPrixtotalDetail()*df.getPourcentageremise())/100;

             df.setMontantRemise(montantRemise);
             df.setFacture(f);

             detailFactureRepository.save(df);
             montantRemiseFacture+=montantRemise;
         }
         f.setMontantRemise(montantRemiseFacture);
         f.setMontantfacture(f.getMontantfacture()-montantRemiseFacture);
        return f;
     }
}
