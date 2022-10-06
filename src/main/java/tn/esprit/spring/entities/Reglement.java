package tn.esprit.spring.entities;

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
public class Reglement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReglement;
    private float montantPaye,montantRestant;
    private boolean payee;
    @Temporal(value = TemporalType.DATE)
    private Date dateReglement;
    @ManyToOne
    private Facture facture;
}
