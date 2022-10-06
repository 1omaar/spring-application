package tn.esprit.spring.entities;

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
public class SecteurActivite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSeteurActivite;
    String codeSecteurActivite, libelleSecteurActivite;
    @ManyToMany
    Set<Fournisseur> fournisseurs=new HashSet<>();
}
