/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.controller;

import atos.magiemagie.entity.Joueur;
import atos.magiemagie.entity.Partie;
import atos.magiemagie.service.JoueurService;
import atos.magiemagie.service.PartieService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author theklaude
 */
@Controller
public class PartieController {

    @Autowired
    private PartieService pservice;

    @Autowired
    private JoueurService jservice;

    @RequestMapping(value = "/demarrer-partie")
    public String demarrerPartieGET(HttpSession session){
        
        pservice.demarrerPartie((Long) session.getAttribute("idPartie"));
        
        return "ma-partie.jsp";
    }
    
    @RequestMapping(value = {"/pseudo-avatar/{idPartie}"}, method = RequestMethod.GET)
    public String RejoindrePartieGet(@PathVariable("idPartie") long id, Model m) {
        Joueur j = new Joueur();
        j.setAvatar("avatar");
        m.addAttribute("joueur", j);

        return "/pseudo-avatar.jsp";
    }

    @RequestMapping(value = {"/pseudo-avatar/{idPartie}"}, method = RequestMethod.POST)
    public String RejoindrePartiePOST(HttpSession session, @PathVariable("idPartie") long idPartie, @ModelAttribute("joueur") Joueur j) {
        j = jservice.rejoindrePartie(j.getPseudo(), j.getAvatar(), idPartie);
        
        session.setAttribute("idJoueur", j.getId());
        session.setAttribute("idPartie", idPartie);
        
        System.out.println("*** " + idPartie + " *** " + j.getId());

        return "redirect:/demarrer-partie";
    }

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String home() {
        return "home.jsp";
    }

    //Form binding ascendant
    @RequestMapping(value = {"/creer-partie"}, method = RequestMethod.GET)
    public String creerPartie(Model creerPartieModel) {
        Partie p = new Partie();
        creerPartieModel.addAttribute("partie", p);
        return "creer-partie.jsp";
    }

    //Form binding descendant
    @RequestMapping(value = {"/creer-partie"}, method = RequestMethod.POST)
    public String creerPartiePOST(@ModelAttribute("partie") Partie p) {
        pservice.creerNouvellePartie(p.getNom());
        return "redirect:/lister-partie";
    }

    @RequestMapping(value = {"/lister-partie"}, method = RequestMethod.GET)
    public String listerPartie(Model m) {
        m.addAttribute("listeParties", pservice.listerPartieNonDemarees());
        return "lister-partie.jsp";
    }

}
