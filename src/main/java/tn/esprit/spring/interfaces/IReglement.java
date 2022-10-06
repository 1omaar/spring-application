package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Reglement;

import java.util.Date;
import java.util.List;

public interface IReglement {
    public List<Reglement> retrieveReglementByFacture(Long idFacture);
   public  Reglement addReglement(Reglement r, Long idFacture);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    public float pourcentageRecouvrement(Date startDate, Date endDate);

}
