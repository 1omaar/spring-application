package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.SecteurActivite;
import tn.esprit.spring.interfaces.ISecteurActivite;

import java.util.List;

@RestController
@RequestMapping("/secteur_activite")
public class SecteurActiviteController {
    @Autowired
    ISecteurActivite secteurActiviteServices;
    @GetMapping("/get_all")
    List<SecteurActivite> getAll (){
        return  secteurActiviteServices.retrieveAllSecteurActivites();
    }
    @PostMapping("/add")
    SecteurActivite addSecteurActivite (@RequestBody SecteurActivite s){
        return  secteurActiviteServices.addSecteurActivite(s);
    }
    @PutMapping("/update")
    SecteurActivite updateSecteurActivite (@RequestBody SecteurActivite s){
        return  secteurActiviteServices.updateSecteurActivite(s);
    }
    @GetMapping("/get/{id}")
    SecteurActivite retrieveById (@PathVariable("id") Long id){
        return  secteurActiviteServices.retrieveSecteurActivite(id);
    }
    @DeleteMapping("/remove/{id}")
    void removeSecteurActivite (@PathVariable() Long id){
        secteurActiviteServices.removeSecteurActivite(id);
    }
    @GetMapping("/assign/{idFournisseur}/{idSecteurAct}")
    void assignSecteurActiviteToFournisseur (@PathVariable("idFournisseur") Long idFournisseur,@PathVariable("idSecteurAct") Long idSecteur){
        secteurActiviteServices.assignSecteurActiviteToFournisseur(idFournisseur,idSecteur);

    }
}
