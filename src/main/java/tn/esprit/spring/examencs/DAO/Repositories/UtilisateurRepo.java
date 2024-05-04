package tn.esprit.spring.examencs.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.examencs.DAO.Entities.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByNomAndPrenom(String nom,String prenom);

}
