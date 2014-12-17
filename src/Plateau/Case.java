/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plateau;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Classe décrivant une case du goban.
 * @author Fabien
 */
public class Case {
    private int x;
    private int y;
    private Joueur p;
    private Goban g;
    /**
     * Constructeur de base de la classe Case, prenant deux entier en paramètres
     * @param x : abscisse
     * @param y : ordonnée
     */
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.p = null;
        this.g = null;
    }
    /**
     * Constructeur avec le plateau de jeu.
     * @param x Abscisse
     * @param y Ordonnée
     * @param g Plateau de jeu
     */
    public Case(int x, int y, Goban g) {
        this.x = x;
        this.y = y;
        this.p = null;
        this.g = g;
    }
    /**
     * Constructeur de recopie de la classe Case
     * @param a : la Case à recopier
     */
    public Case(Case a){
        this.x= a.getX();
        this.y= a.getY();
        this.p = a.getJoueur();
        this.g = a.getGoban();
    }
    /**
     * Méthode retournant l'abscisse de la case
     * @return l'abscisse sous forme d'un entier
     */
    public int getX() {
        return x;
    }
    /**
     * Méthode retournant le joueur auquel appartient la pierre posée sur la case.
     * Si aucune pierre n'est posée, le joueur est null.
     * @return le joueur en question.
     */
    public Joueur getJoueur() {
        return p;
    }
    /**
     * Méthode retournant l'ordonnée de la case
     * @return l'ordonnée sous forme d'un entier
     */
    public int getY() {
        return y;
    }
    /**
     * Méthode retournant le plateau de jeu de la case.
     * @return le plateau de jeu.
     */
    public Goban getGoban(){
        return g;
    }
    /**
     * Méthode permettant de changer le joueur qui contrôle la case
     * @param p de type Joueur
     */
    public void setJoueur(Joueur p){
        this.p=p;
    }
    
    public void setGoban(Goban g){
        this.g = g;
    }
    
    /**
     * Permet de savoir si une case est libre ou pas (si il y a déjà une pierre dessus)
     * @param pos
     * @return 
     */
    public boolean caseLibre(){
        return (this.p==null);
    }
    
    public boolean caseJouable(){
        boolean a;
        a=(caseLibre()||!(this.g.horsPlateau(this.x,this.y)));
        if(nombreLibertésAutourDe()<1){
            a=false;
        }
        return a;
    }

    public int nombreLibertésAutourDe() {
        int n=0;
        ArrayList<Case> a = (ArrayList<Case>) g.getCasesAutourDe(this);
        for (Case a1 : a) {
            if (a1.caseLibre()) {
                n++;
            }
        }
            
        return n;
    }
    
    public Groupe getGroupe(){
        for (Groupe grp : g.getGroupes()){
            if (grp.getPierres().contains(this)){
                return grp;
            }
        }
        return null;
    }
    
    public ArrayList<Groupe> getGroupesAdjacents(){
        HashSet<Groupe> groupes = new HashSet<>();
        ArrayList<Case> cases = g.getCasesAutourDe(this);
        for (Case c : cases){
            if (c.getGroupe() != null) {
                groupes.add(c.getGroupe());
            }
        }
        return new ArrayList<>(groupes);
    }
    
    
    
}
