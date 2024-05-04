package tn.esprit.spring.examencs.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.examencs.DAO.Entities.Livre;

public interface LivreRepo extends JpaRepository<Livre,Long> {
}
