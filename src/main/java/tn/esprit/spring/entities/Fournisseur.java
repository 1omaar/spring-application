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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFournisseur;
    String codeFournisseur,libelleFournisseur ;
    CategorieFournisseur categorieFournisseur;
    @OneToMany(mappedBy = "fournisseur")
    @JsonIgnore
    Set<Facture> factures = new HashSet<>();
    @OneToOne
    DetailFournisseur detailFournisseur;
    @ManyToMany (mappedBy = "fournisseurs")
    Set<SecteurActivite> secteurActivites = new HashSet<>();
}
