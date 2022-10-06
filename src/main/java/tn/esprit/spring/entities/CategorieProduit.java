package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorieProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategorieProduit;
    String codeProduit,libelleCategorieProduit;
    @OneToMany(mappedBy = "categorieProduit")
    @JsonIgnore
    Set<Produit> produits = new HashSet<>();
}
