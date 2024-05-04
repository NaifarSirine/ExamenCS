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
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idLivre;
    String nom;
    @Enumerated(EnumType.STRING)
    TypeLivre type;
    LocalDate dateEmission;
    boolean reserve;
    LocalDate dateReservation;

    @OneToOne(mappedBy = "livre")
    Utilisateur lecteur;

    @ManyToOne(cascade = CascadeType.ALL)
    Utilisateur auteur;




}
