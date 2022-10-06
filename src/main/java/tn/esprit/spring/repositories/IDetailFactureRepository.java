package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.DetailFacture;

public interface IDetailFactureRepository extends JpaRepository<DetailFacture,Long> {
}
