package tn.esprit.spring.examencs.Services;

import tn.esprit.spring.examencs.DAO.Entities.Bibliotheque;
import tn.esprit.spring.examencs.DAO.Entities.Livre;
import tn.esprit.spring.examencs.DAO.Entities.Utilisateur;

import java.time.LocalDate;
import java.util.List;

public interface IServices {
    Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque);
    List<Utilisateur> ajouterLecteurs(List<Utilisateur> lecteurs) ;
    Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(Livre l, String nomBibliotheque);
    String affecterLivreALecteur(long idLivre, long idLecteur);
    void modifierDateReservation(LocalDate date, long idLecteur);
    String rendreLivre(String nom, String prenom);
}
