package tn.esprit.spring.examencs.DAO.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUser;
    String nom;
    String prenom;
    String nationalite;
    @Enumerated(EnumType.STRING)
    Role role;
    LocalDate dateDebutAbonnement;
    LocalDate dateFinAbonnement;
    @Enumerated(EnumType.STRING)
    Etat etat;
    @OneToOne
    Livre livre;
    @OneToMany(mappedBy = "auteur")
    List<Livre> livres= new ArrayList<>();

}
