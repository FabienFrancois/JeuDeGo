/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plateau;

import java.util.ArrayList;

/**
 * Classe décrivant le goban.
 * @author Fabien
 */
public class Goban {
    private int taille;
    private Case cases[][];
    
    public Goban(int taille){
        this.taille=taille;
        for (int i=0; i<taille; i++){
            for (int j=0; j<taille; j++){
                cases[i][j]=new Case(i,j);
            }
        }
    }
    /**
     * Méthode retournant la taille du goban
     * @return int : taille
     */
    public int getTaille() {
        return taille;
    }
    
    /**
     * Permet de savoir si une case est libre ou pas (si il y a déjà une pierre dessus)
     * @param pos
     * @return 
     */
    public boolean caseLibre(Case pos){
        boolean a;
        if (pos.getJoueur()==null){
            a=true;
        }
        else{
            a=false;
        }
        return a;
    }
    
    public boolean caseJouable(Case pos){
        boolean a;
        a=(caseLibre(pos)||!(horsPlateau(pos.getX(),pos.getY())));
        if(nombreLibertésAutourDe(pos)<1){
            a=false;
        }
        return a;
    }

    private int nombreLibertésAutourDe(Case pos) {
        int n=0;
        ArrayList<Case> a = new ArrayList();
            a=getCasesAutourDe(pos);
            for(int i=0;i<a.size();i++){
                if(caseLibre(a.get(i))){
                    n++;
                }
            }
            
        return n;
    }
    
    
    
}
