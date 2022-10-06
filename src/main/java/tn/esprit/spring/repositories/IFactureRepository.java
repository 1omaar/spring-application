package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Facture;

import java.util.List;

public interface IFactureRepository  extends JpaRepository<Facture,Long> {
    List<Facture> findByFournisseur_IdFournisseur(Long idFournisseur);


}
