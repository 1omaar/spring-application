package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.SecteurActivite;

public interface ISecteurActiviteRepository extends JpaRepository<SecteurActivite,Long> {
}
