/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plateau;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Représente un groupe de pierres adjacentes.
 * @author Benjamin
 */
public class Groupe {
    private ArrayList<Case> pierres;
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
    
    public ArrayList<Case> getPierres(){
        return pierres;
    }
    
    public void addPierre(Case pierre){
        pierres.add(pierre);
    }
    
    public ArrayList<Case> getLiberte(){
        ArrayList<Case> lib = new ArrayList<>();
        for (Case c1 : pierres){
            lib.removeAll(this.g.getCasesAutourDe(c1));
            lib.addAll(this.g.getCasesAutourDe(c1));
        }
        return lib;
    }
    
    public boolean isCapture(){
        return (this.getLiberte().isEmpty());
    }
}
