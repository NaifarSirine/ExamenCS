package tn.esprit.spring.examencs.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.examencs.DAO.Entities.Bibliotheque;

public interface BibliothequeRepo extends JpaRepository<Bibliotheque,Long> {
    Bibliotheque findByNom(String nom);
}
