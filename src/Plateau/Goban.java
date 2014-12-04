/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plateau;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe décrivant le goban.
 * @author Fabien
 */
public class Goban {
    private int taille;
    private Case cases[][];
    
    public Goban(int taille){
        this.taille=taille;
        cases = new Case[taille][taille];
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
            a=(ArrayList<Case>) getCasesAutourDe(pos);
            for(int i=0;i<a.size();i++){
                if(caseLibre(a.get(i))){
                    n++;
                }
            }
            
        return n;
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
}
