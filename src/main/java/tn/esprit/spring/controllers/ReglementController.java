package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Reglement;
import tn.esprit.spring.interfaces.IReglement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reglement")
public class ReglementController {
    @Autowired
    IReglement iReglement;

    @GetMapping("/get/{id}")
    public List<Reglement> retrieveReglementByFacture(@PathVariable("id") Long idFacture) {
        return iReglement.retrieveReglementByFacture(idFacture);
    }
    @PostMapping("/add/{id}")
    public Reglement addReglement(@RequestBody Reglement r, @PathVariable("id") Long idFacture) {
    return  iReglement.addReglement(r,idFacture);
    }
    @PostMapping("/get_between_date")
    public  float get ( @RequestBody Map<String,Date> httpEntity)  {

        return iReglement.getChiffreAffaireEntreDeuxDate(httpEntity.get("dateStart"),httpEntity.get("dateEnd"));
    }
    @PostMapping("/get_pourcentage_between_date")
    public  float pourcentageRecouvrement ( @RequestBody Map<String,Date> httpEntity)  {

        return iReglement.pourcentageRecouvrement(httpEntity.get("dateStart"),httpEntity.get("dateEnd"));
    }
}
