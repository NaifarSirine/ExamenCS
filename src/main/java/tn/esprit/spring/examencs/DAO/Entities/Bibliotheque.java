package tn.esprit.spring.examencs.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bibliotheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idBiblio;
    String nom;
    String adresse;
    long telephone;
    @OneToMany
    List<Livre> livres= new ArrayList<>();
}
