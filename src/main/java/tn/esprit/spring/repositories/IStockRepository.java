package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Stock;

public interface IStockRepository extends JpaRepository<Stock,Long> {
}
