package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.interfaces.IProduit;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProduitController {
    @Autowired
    IProduit produitService;
    @PostMapping ("/add/{idStock}/{idCategorie}")
    Produit addProduit (@RequestBody  Produit p,@PathVariable("idStock")Long idStock,@PathVariable("idCategorie")Long idCat){
       return   produitService.addProduit(p,idCat,idStock);
    }
    @GetMapping("/getAll")
    List<Produit> getAll (){
        return produitService.retrieveAllProduits();
    }
    @PutMapping("/update/{idStock}/{idCat}")
    Produit updateProduit (@RequestBody Produit p , @PathVariable("idStock") Long idStock , @PathVariable("idCat") Long idCat){
        return  produitService.updateProduit(p,idCat,idStock);
    }
    @GetMapping("/get/{id}")
    Produit getById (@PathVariable("id") Long id){
        return  produitService.retrieveProduit(id);
    }
    @GetMapping("/assign/{idProduit}/{idStock}")
    void assignProduitToStock (@PathVariable("idProduit") Long idProduit , @PathVariable("idStock") Long idStock){
        produitService.assignProduitToStock(idProduit,idStock);
    }

}
