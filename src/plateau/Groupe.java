/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateau;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Représente un groupe de pierres adjacentes.
 * @author Benjamin
 */
public class Groupe {
    private List<Case> pierres;
    private Goban g;
    /**
     * Constructeur basique.
     */
    public Groupe(){
        this.pierres = new ArrayList<>();
        this.g = null;
    }
    /**
     * Constructeur qui associe un plateau au groupe.
     * @param g de type Goban : Le plateau associé.
     */
    public Groupe(Goban g){
        this.pierres = new ArrayList<>();
        this.g = g;
    }
    /**
     * Permet de changer le plateau du groupe.
     * @param g de type Goban : Le nouveau plateau.
     */
    public void setGoban(Goban g){
        this.g = g;
    }
    /**
     * Permet d'accéder à la liste des pierres du groupe.
     * @return de type List(Case) : La liste des pierres.
     */
    public List<Case> getPierres(){
        return pierres;
    }
    /**
     * Permet d'ajouter une pierre au groupe.
     * @param pierre de type Case : La pierre à ajouter.
     */
    public void addPierre(Case pierre){
        pierres.add(pierre);
    }
    /**
     * Permet de calculer les libertés de l'ensemble des cases d'un groupe.
     * @return de type List(Case) : Les cases correspondants aux libertés du groupe.
     */
    public List<Case> getLiberte(){
        Set<Case> libSet = new HashSet<>();
        for (Case c1 : pierres){
            for(Case c : (ArrayList<Case>)this.g.getCasesAutourDe(c1)){
                if (c.caseLibre()){
                    libSet.add(c);
                }
            }
        }
        return new ArrayList<>(libSet);
    }
    /**
     * Permet de déterminer si un groupe est capturé.
     * @return de type boolean : true si le groupe est capturé.
     */
    public boolean isCapture(){
        return this.getLiberte().isEmpty();
    }
    
    /**
     * Enlève un groupe de pierres capturées du plateau
     */
    public void pierresCapturees(){
        if(isCapture()){
            if(pierres.get(0).getJoueur().equals(g.getPlayer1())){
                g.getPlayer2().setNbPierresCapturees(g.getPlayer2().getNbPierresCapturees()+pierres.size());
            } else{
                g.getPlayer1().setNbPierresCapturees(g.getPlayer1().getNbPierresCapturees()+pierres.size());
            }
            for(Case c1 : pierres){
                c1.setJoueur(null);
            }
            g.retirerGroupe(this);
        }
    }
    /**
     * Permet de faire fusionner deux groupes adjacents.
     * @param groupe de type Groupe : Le groupe à absorber.
     */
    public void absorbGroupe(Groupe groupe){
        this.pierres.addAll(groupe.getPierres());
        this.g.retirerGroupe(groupe);
    }
}
