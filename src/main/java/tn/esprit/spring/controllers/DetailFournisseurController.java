package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.DetailFournisseur;
import tn.esprit.spring.interfaces.IDetailFournisseur;

@RestController
@RequestMapping("/detailFournisseur")
public class DetailFournisseurController {
@Autowired
    IDetailFournisseur detailFournisseurServices;
@PostMapping("/add")
    DetailFournisseur addDetailfournisseur (DetailFournisseur df){
    return detailFournisseurServices.addDetailFournisseur(df);
}

}
