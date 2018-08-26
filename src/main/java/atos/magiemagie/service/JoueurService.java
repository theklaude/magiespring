/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.service;

import atos.magiemagie.dao.JoueurDAO;
import atos.magiemagie.dao.JoueurDAOCrud;
import atos.magiemagie.dao.PartieDAO;
import atos.magiemagie.dao.PartieDAOCrud;
import atos.magiemagie.entity.Joueur;
import atos.magiemagie.entity.Partie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author theklaude
 */
@Service
public class JoueurService {

    @Autowired
    private JoueurDAOCrud jDaoCrud;

    @Autowired
    private PartieDAOCrud pDaoCrud;

    private JoueurDAO joueurDAO = new JoueurDAO();
    private PartieDAO partieDAO = new PartieDAO();

    @Autowired
    private CarteService carteServ;
    @Autowired
    private PartieService partieServ;

    @Transactional
    public Joueur rejoindrePartie(String pseudo, String avatar, long idPartie) {
        //Recherche si joueur existe déjà
        Joueur joueur = jDaoCrud.findOneByPseudo(pseudo);
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
        Partie partie = pDaoCrud.findOne(idPartie);
        joueur.setPartie(partie);
        List<Joueur> listeJoueurs = partie.getJoueurs();
        listeJoueurs.add(joueur);

        return jDaoCrud.save(joueur);
    }

    public void passerMain(long idJoueur) {

        carteServ.distribuerUneCarteAleatoirement(idJoueur);
        partieServ.passeJoueurSuivant(idJoueur);

    }

}
