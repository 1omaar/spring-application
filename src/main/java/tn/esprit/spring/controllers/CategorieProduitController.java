package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.interfaces.ICategorieProduit;

import java.util.List;

@RestController
@RequestMapping("categorieProduit")
public class CategorieProduitController {
@Autowired
    ICategorieProduit categorieProduit;
@GetMapping("/getAll")
List<CategorieProduit>afficherCatgories (){
    return categorieProduit.retrieveAllCategorieProduits();
}
@PostMapping("/add")
CategorieProduit ajouterCategorie(@RequestBody CategorieProduit cp) throws Exception {
    return categorieProduit.addCategorieProduit(cp);
}

@PutMapping("/update")
    CategorieProduit updateCategorie(@RequestBody CategorieProduit cp){
    return  categorieProduit.updateCategorieProduit(cp);
}
@DeleteMapping("/delete/{id}")
    void  deteleCategorie(@PathVariable("id") Long idCategorie ){
    categorieProduit.removeCategorieProduit(idCategorie);
}
@GetMapping("/get/{id}")
    CategorieProduit getByIdCategorie (@PathVariable("id") Long id ){
    return  categorieProduit.retrieveCategorieProduit(id);
}
}
