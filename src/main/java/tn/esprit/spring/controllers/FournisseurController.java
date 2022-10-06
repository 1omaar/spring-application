package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.interfaces.IFournisseur;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
    @Autowired
    IFournisseur fournisseurService;

    @PostMapping("/add")
    Fournisseur addFournisseur (@RequestBody Fournisseur f){
        return fournisseurService.addFournisseur(f);
    }
    @GetMapping("/get_all")
    List<Fournisseur> getAll (){
        return  fournisseurService.retrieveAllFournisseurs();
    }
    @GetMapping("/get/{id}")
    Fournisseur getById (@PathVariable("id") Long id){
        return  fournisseurService.retrieveFournisseur(id);
    }
     @PutMapping("/update")
    Fournisseur update(@RequestBody Fournisseur f){
        return  fournisseurService.updateFournisseur(f);
    }
}
