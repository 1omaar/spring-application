package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.DetailFournisseur;

public interface IDetailFournisseurRepository extends JpaRepository<DetailFournisseur,Long> {

}
