package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private float montantRemise,montantfacture;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreationFacture, dateDerniereModification;
    private boolean archive;
    @OneToMany(mappedBy = "facture")
    @JsonIgnore
    private Set<Reglement>reglements= new HashSet<>();
    @OneToMany(mappedBy = "facture")
    Set<DetailFacture> detailFactures = new HashSet<>();
    @ManyToOne
    Fournisseur fournisseur;

}
