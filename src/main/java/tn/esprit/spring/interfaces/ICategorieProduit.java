package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.CategorieProduit;

import java.util.List;

public interface ICategorieProduit {
    public List<CategorieProduit> retrieveAllCategorieProduits();
    public CategorieProduit addCategorieProduit(CategorieProduit cp) throws Exception;
    public CategorieProduit updateCategorieProduit(CategorieProduit cp);
    public CategorieProduit retrieveCategorieProduit(Long id);
    public void removeCategorieProduit(Long id);

}
