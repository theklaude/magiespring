/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.service;

import atos.magiemagie.dao.CarteDAO;
import atos.magiemagie.dao.CarteDAOCrud;
import atos.magiemagie.dao.JoueurDAO;
import atos.magiemagie.dao.JoueurDAOCrud;
import atos.magiemagie.dao.PartieDAO;
import atos.magiemagie.dao.PartieDAOCrud;
import atos.magiemagie.entity.Joueur;
import atos.magiemagie.entity.Partie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author theklaude
 */
@Service
public class JoueurService {

    @Autowired
    private JoueurDAOCrud jDaoCrud;

    @Autowired
    private CarteDAOCrud cDaoCrud;

    @Autowired
    private PartieDAOCrud pDaoCrud;

    private JoueurDAO joueurDAO = new JoueurDAO();
    private PartieDAO partieDAO = new PartieDAO();
    private CarteService carteServ = CarteService.instantiate();
    private PartieService partieServ = new PartieService();
    private CarteDAO carteDAO = new CarteDAO();

    public Joueur rejoindrePartie(String pseudo, String avatar, long idPartie) {
        //Recherche si joueur existe déjà
        Joueur joueur = joueurDAO.rechercherParPseudo(pseudo);
        if (joueur == null) {
            // Le jour n'existe pas encore
            joueur = new Joueur();
            joueur.setPseudo(pseudo);
            joueur.setNbPartiesJouees(0L);
            joueur.setNbPartiesGagnees(0L);
        }
        joueur.setAvatar(avatar);
        joueur.setEtat(Joueur.EtatJoueur.PAS_LA_MAIN);
        long ordre = joueurDAO.rechercheOrdreNouveauJoueurPourPartie(idPartie);
        joueur.setOrdre(ordre);

        //Associe le joueur à la partie et vice-versa (JPA relations bidirectionnelles
        Partie partie = partieDAO.recherchePartieId(idPartie);
        joueur.setPartie(partie);
        List<Joueur> listeJoueurs = partie.getJoueurs();
        listeJoueurs.add(joueur);

        if (joueur.getId() == null) {
            joueurDAO.ajouter(joueur);
        } else {
            joueurDAO.modifier(joueur);
        }
        return joueur;
    }

    public void passerMain(long idJoueur) {

        carteServ.distribuerUneCarteAleatoirement(idJoueur);
        partieServ.passeJoueurSuivant(idJoueur);

    }

}
