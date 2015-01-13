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
    
    public Groupe(){
        this.pierres = new ArrayList<>();
        this.g = null;
    }
    
    public Groupe(Goban g){
        this.pierres = new ArrayList<>();
        this.g = g;
    }
    
    public void setGoban(Goban g){
        this.g = g;
    }
    
    public List<Case> getPierres(){
        return pierres;
    }
    
    public void addPierre(Case pierre){
        pierres.add(pierre);
    }
    
    public ArrayList<Case> getLiberte(){
        Set<Case> libSet = new HashSet<>();
        for (Case c1 : pierres){
            for(Case c : (ArrayList<Case>)this.g.getCasesAutourDe(c1)){
                if (c.caseLibre()){
                    libSet.add(c);
                }
            }
        }
        ArrayList<Case> lib = new ArrayList<>(libSet);
        return lib;
    }
    
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
    
    public void absorbGroupe(Groupe groupe){
        this.pierres.addAll(groupe.getPierres());
        this.g.retirerGroupe(groupe);
    }
}
