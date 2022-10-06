package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailFournisseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDetailFournisseur;
    @Temporal(value = TemporalType.TIMESTAMP)
    Date dateDebutCollaboration;
    String adresse, matricule;
    @OneToOne (mappedBy = "detailFournisseur")
    @JsonIgnore
    Fournisseur fournisseur;
}
