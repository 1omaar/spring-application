package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.interfaces.IFacture;
import tn.esprit.spring.repositories.IFactureRepository;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureController {
    @Autowired
    IFacture factureServices;
    @GetMapping("/get_all")
    List<Facture> getAll(){
       return factureServices.retrieveAllFactures();
    }

    @GetMapping("/get/{id}")
    Facture retrievebyId (@PathVariable("id") Long id){
        return  factureServices.retrieveFacture(id);
    }
    @GetMapping("/assign/{idOp}/{idFac}")
    void assignOperateurToFacture (@PathVariable("idOp") Long idOp, @PathVariable("idFac") Long idFac){
        factureServices.assignOperateurToFacture(idOp,idFac);
    }
    @GetMapping("/get_by_fournisseur/{id}")
    List<Facture> getByFournisseur(@PathVariable("id") Long id){
        return factureServices.getFacturesByfournisseur(id);
    }
    @PostMapping("/add/{id}")
    Facture addFacture(@RequestBody Facture f,@PathVariable("id") Long idFournisseur){
        return factureServices.addFacture(f,idFournisseur);
    }
}
