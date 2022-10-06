package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Reglement;
import tn.esprit.spring.interfaces.IFacture;
import tn.esprit.spring.interfaces.IReglement;
import tn.esprit.spring.repositories.IReglementrepository;

import java.util.*;

@Service
public class ReglementService implements IReglement {
    @Autowired
    IReglementrepository reglementrepository;

    @Autowired
    IFacture factureService;

    @Override
    public List<Reglement> retrieveReglementByFacture(Long idFacture) {
        return reglementrepository.findByFacture_IdFacture(idFacture);
    }

    @Override
    public Reglement addReglement(Reglement r, Long idFacture) {
        Facture f = factureService.retrieveFacture(idFacture);
        List<Reglement> reglementList = new ArrayList<>();
        reglementList.addAll(retrieveReglementByFacture(idFacture));
        float sommeReglement = 0;
        for (Reglement reglement:reglementList) {
            sommeReglement+=reglement.getMontantPaye();
        }
        float restant = f.getMontantfacture()-sommeReglement;
        if (r.getMontantPaye()<= restant){
            r.setFacture(f);
            return reglementrepository.save(r);
        }
        System.out.println("reglement refuseé");
        return null;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Reglement>  reglementList = reglementrepository.findAllByDateReglementBetween(startDate,endDate);
        float montant=0;
        for (int i = 0 ; i<reglementList.size();i++){
            if ( reglementList.get(i).getFacture().isArchive()){

                reglementList.remove(i);
            }else {
                montant+=reglementList.get(i).getMontantPaye();
            }
        }

        return montant;
    }

    @Override
    public float pourcentageRecouvrement(Date startDate, Date endDate) {
        List<Reglement>  reglementList = reglementrepository.findAllByDateReglementBetween(startDate,endDate);
        Set<Facture>factureSet = new HashSet<>();
        float sommeFacture=0;
        for (int i = 0 ; i<reglementList.size();i++){
            if ( reglementList.get(i).getFacture().isArchive()){

                reglementList.remove(i);
            }else {

                factureSet.add(reglementList.get(i).getFacture());
            }
        }
        for (Facture facture : factureSet){
            sommeFacture+=facture.getMontantfacture();
        }
        return getChiffreAffaireEntreDeuxDate(startDate,endDate)/sommeFacture;
    }
}
