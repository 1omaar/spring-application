package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailFacture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDetailFacture;
    int qteCommandes, pourcentageremise;
    float prixtotalDetail, montantRemise;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore

    Facture facture;
    @ManyToOne
    Produit produit;
}
