package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.exceptions.InvalidEntityException;
import tn.esprit.spring.exceptions.InvalidRequiredException;
import tn.esprit.spring.interfaces.ICategorieProduit;
import tn.esprit.spring.repositories.ICategorieProduitRepository;

import java.util.List;
@Service
public class CategorieProduitService implements ICategorieProduit {
    @Autowired
    ICategorieProduitRepository categorieProduitRepository;
    @Override
    public List<CategorieProduit> retrieveAllCategorieProduits() {
        return categorieProduitRepository.findAll();
    }

    @Override
    public CategorieProduit addCategorieProduit(CategorieProduit cp) throws Exception {
        if (cp==null){
            throw  new InvalidEntityException("entity empty!!");

        }
        if (cp.getCodeProduit()==null){
            throw new InvalidRequiredException("code of entity is required");
        }
        return categorieProduitRepository.save(cp);
    }

    @Override
    public CategorieProduit updateCategorieProduit(CategorieProduit cp) {
        return categorieProduitRepository.save(cp);
    }

    @Override
    public CategorieProduit retrieveCategorieProduit(Long id) {
        return categorieProduitRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCategorieProduit(Long id) {
        categorieProduitRepository.deleteById(id);
    }
}
