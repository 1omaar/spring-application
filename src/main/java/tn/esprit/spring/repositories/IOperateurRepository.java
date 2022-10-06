package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Operateur;

public interface IOperateurRepository extends JpaRepository<Operateur,Long> {
}
