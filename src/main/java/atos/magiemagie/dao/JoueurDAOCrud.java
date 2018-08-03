/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atos.magiemagie.dao;

import atos.magiemagie.entity.Joueur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author theklaude
 */
public interface JoueurDAOCrud extends CrudRepository<Joueur, Long> {

    public Joueur findOneByPseudo(String pseudo);

    public Joueur findOneByPartieIdAndOrdre(long idPartie, long ordre);

//    public Joueur countByJoueurAndPartieId(long joueurId, long partieId);
    
//    @Query ("SELECT MAX(j.ordre)+1 "
//                + "FROM Joueur j "
//                + "JOIN j.partie p "
//                + "WHERE p.id=atos.magiemagie.entity.Partie.partieId ");
//    public long rechercheOrdreNouveauJoueurPourPartie(long partieId);
}
