package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Operateur;

import java.util.List;

public interface IOperateur {
    public List<Operateur> retrieveAllOperateurs();

   public  Operateur addOperateur (Operateur o);

   public  Operateur updateOperateur (Operateur o);

   public Operateur retrieveOperateur (Long id);

   public void removeOperateur (Long id);


}
