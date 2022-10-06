package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Operateur;
import tn.esprit.spring.interfaces.IOperateur;

import java.util.List;

@RestController
@RequestMapping("/operateur")
public class OperateurController {
    @Autowired
    IOperateur operateurServices;
    @GetMapping("/getAll")
    List<Operateur> getAll (){
        return operateurServices.retrieveAllOperateurs();
    }
    @PostMapping("/add")
    Operateur addOperateur (@RequestBody Operateur op){
        return operateurServices.addOperateur(op);
    }
    @PutMapping("/update")
    Operateur updateOperateur (@RequestBody Operateur op){
        return  operateurServices.updateOperateur(op);
    }
    @GetMapping("/get/{id}")
    Operateur getById(@PathVariable("id") Long id){
        return  operateurServices.retrieveOperateur(id);
    }
    @DeleteMapping("/delete/{id}")
    void remove (@PathVariable("id") Long id){
         operateurServices.removeOperateur(id);
    }
}
