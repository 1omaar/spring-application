package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Reglement;

import java.util.Date;
import java.util.List;

public interface IReglementrepository extends JpaRepository<Reglement,Long> {
    List<Reglement> findByFacture_IdFacture(Long idFacture);
    List<Reglement> findAllByDateReglementBetween(Date startDate,Date endDate);


}
