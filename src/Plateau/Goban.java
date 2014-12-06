/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plateau;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe décrivant le goban.
 * @author Fabien
 */
public class Goban {
    private int taille;
    private Case cases[][];
    private LinkedList<Groupe> groupes;
    
    public Goban(int taille){
        this.taille=taille;
        cases = new Case[taille][taille];
        for (int i=0; i<taille; i++){
            for (int j=0; j<taille; j++){
                cases[i][j]=new Case(i,j,this);
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
     * Méthode retournant la case située en i, j sur le plateau
     * @param i : abscisse de la case
     * @param j : ordonnée de la case
     * @return la Case en question
     */
    public Case getCase(int i, int j){
        return cases[i][j];
    }
    
    
    public boolean horsPlateau(int a, int b){
        return (!(a>=0 && a<taille && b>=0 && b<taille));
    }
    
    public List<Case> getCasesAutourDe(Case pos){
        ArrayList<Case> a= new ArrayList<>();
        if(!horsPlateau(pos.getX()-1, pos.getY())){
            a.add(cases[pos.getX()-1][pos.getY()]);
        }
        if(!horsPlateau(pos.getX()+1, pos.getY())){
            a.add(cases[pos.getX()+1][pos.getY()]);
        }
        if(!horsPlateau(pos.getX(), pos.getY()+1)){
            a.add(cases[pos.getX()][pos.getY()+1]);
        }
        if(!horsPlateau(pos.getX(), pos.getY()-1)){
            a.add(cases[pos.getX()][pos.getY()-1]);
        }
        return a;
    }
    
    public boolean isDansGroupe(Case c){
        for (Groupe g : groupes){
            if (g.getPierres().contains(c)){
                return true;
            }
        }
        return false;
    }
}
