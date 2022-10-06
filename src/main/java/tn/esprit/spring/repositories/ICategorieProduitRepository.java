package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.CategorieProduit;

public interface ICategorieProduitRepository extends JpaRepository<CategorieProduit,Long> {
}
