package tn.esprit.spring.examencs.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.examencs.DAO.Entities.Bibliotheque;
import tn.esprit.spring.examencs.DAO.Entities.Livre;
import tn.esprit.spring.examencs.DAO.Entities.Utilisateur;
import tn.esprit.spring.examencs.DAO.Repositories.BibliothequeRepo;
import tn.esprit.spring.examencs.DAO.Repositories.LivreRepo;
import tn.esprit.spring.examencs.DAO.Repositories.UtilisateurRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class Services implements IServices {
    BibliothequeRepo bibliothequeRepo;
    UtilisateurRepo utilisateurRepo;
    LivreRepo livreRepo;

    @Override
    public Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque) {
        return bibliothequeRepo.save(bibliotheque);
    }

    @Override
    public List<Utilisateur> ajouterLecteurs(List<Utilisateur> lecteurs) {
        return utilisateurRepo.saveAll(lecteurs);
    }

    @Override
    public Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(Livre l, String nomBibliotheque) {
        Bibliotheque bibliotheque = bibliothequeRepo.findByNom(nomBibliotheque);
        // Livre Parent / utilisateur(Auteur) Child --> Cascade
        l = livreRepo.save(l);
        bibliotheque.getLivres().add(l);
        return bibliothequeRepo.save(bibliotheque);
    }

    @Override
    public String affecterLivreALecteur(long idLivre, long idLecteur) {
        Livre livre = livreRepo.findById(idLivre).get();
        Utilisateur utilisateur = utilisateurRepo.findById(idLecteur).get();
        String msg = "";
        if (utilisateur.getLivre() != null) {
            msg = "Le livre " + livre.getNom() + " est déjà reservé";
        } else {
            // Livre: Child  / Utilsateur(Lecteur): Parent
            // On affecte le child au parent
            utilisateur.setLivre(livre);
            livre.setReserve(true);
            livre.setDateReservation(LocalDate.now());
            livreRepo.save(livre);
            utilisateurRepo.save(utilisateur);
            msg = "L'affectation du " + livre.getNom() + " au lecteur" + utilisateur.getNom() + ""
                    + utilisateur.getPrenom() + " est effectué avec succès !";
        }
        return msg;
    }

    @Override
    public void modifierDateReservation(LocalDate date, long idLecteur) {
        Utilisateur utilisateur = utilisateurRepo.findById(idLecteur).get();
        Livre livre = utilisateur.getLivre();
        livre.setDateReservation(date);
        livreRepo.save(livre);
    }

    @Override
    public String rendreLivre(String nom, String prenom) {
        return null;
    }
}
