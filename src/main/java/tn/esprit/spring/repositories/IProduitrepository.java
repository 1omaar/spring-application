package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Produit;

public interface IProduitrepository extends JpaRepository<Produit,Long> {
}
