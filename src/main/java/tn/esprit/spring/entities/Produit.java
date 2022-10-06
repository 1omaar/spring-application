package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduit;
    String codeProduit, libelleProduit;
    float prix;
    @Temporal(value = TemporalType.TIMESTAMP)
    Date dateCreation,dateDerniereModification;
    @OneToMany(mappedBy = "produit")
    Set<DetailFacture> detailFactures = new HashSet<>();
    @ManyToOne
    CategorieProduit categorieProduit ;
    @ManyToOne
    Stock stock;
}
