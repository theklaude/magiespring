/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.service;

import atos.magiemagie.dao.CarteDAOCrud;
import atos.magiemagie.dao.JoueurDAOCrud;
import atos.magiemagie.entity.Carte;
import atos.magiemagie.entity.Joueur;
import atos.magiemagie.entity.Partie;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author theklaude
 */
@Service
public class CarteService {

    private static CarteService myself = new CarteService();

    public static CarteService instantiate() {
        return myself;
    }

    @Autowired
    private JoueurDAOCrud jDaoCrud;

    @Autowired
    private CarteDAOCrud cDaoCrud;

    @Autowired
    private PartieService partieServ;

    public void distribuerUneCarteAleatoirement(long joueurId) {
        Joueur j = jDaoCrud.findOne(joueurId);
        Carte c = new Carte();
        int pick = new Random().nextInt(c.typeCarte.values().length);
        c.setTypeCarte(Carte.Ingredients.values()[pick]);
        j.getCartes().add(c);
        c.setJoueur(j);
        cDaoCrud.save(c);
    }

    public void prendreUneCarteAleatoirement(long idLanceur, long idVictime) {
        Joueur lanceur = jDaoCrud.findOne(idLanceur);
        Joueur victime = jDaoCrud.findOne(idVictime);
        ajouterUneCarte(RecupCarteAleatoireChezJoueur(victime), lanceur);
    }

    //le joueur de votre choix vous donne la moitié de ses cartes(au hasard). 
    //S’il ne possède qu’une carte il a perdu
    public void sortPhiltreAmour(long idLanceur, long idVictime) {
        Joueur lanceur = jDaoCrud.findOne(idLanceur);
        Joueur victime = jDaoCrud.findOne(idVictime);

        int nbreCarte = (victime.getCartes().size()) / 2;

        for (int i = 1; i <= nbreCarte; i++) {
            ajouterUneCarte(RecupCarteAleatoireChezJoueur(victime), lanceur);
        }

    }

    //tu échanges une carte de son choix contre trois cartes(au hasard) de la victime que tu choisis
    public void sortHypnose(long idLanceur, Carte c, Long idVictime) {
        Joueur lanceur = jDaoCrud.findOne(idLanceur);
        Joueur victime = jDaoCrud.findOne(idVictime);
        for (int i = 1; i <= 3; i++) {
            ajouterUneCarte(RecupCarteAleatoireChezJoueur(victime), lanceur);
        }
        ajouterUneCarte(c, victime);
    }

    public void sortDivination(long idPartie, Long idLanceur) {
        Joueur lanceur = jDaoCrud.findOne(idLanceur);
        String s = String.valueOf(idPartie);
        Partie p = partieServ.recherchePartieParNom(s);

        List<Joueur> jList = p.getJoueurs();
        jList.remove(lanceur);
        for (Joueur j : jList) {
            listerCarte(j.getId());
        }

    }

    public List listerCarte(long idJoueur) {
        Joueur j = jDaoCrud.findOne(idJoueur);
        return j.getCartes();
    }

    private Carte RecupCarteAleatoireChezJoueur(Joueur joueur) {
        Random randomizer = new Random();
        List<Carte> cartesVictime = joueur.getCartes();
        return cartesVictime.get(randomizer.nextInt(cartesVictime.size()));
    }

    private void ajouterUneCarte(Carte c, Joueur j) {
        j.getCartes().add(c);
        c.setJoueur(j);
        cDaoCrud.save(c);
    }
}
