/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Plateau;

import java.util.Scanner;

/**
 *Représente un des deux joueurs
 * @author arigoure
 */
public class Joueur {
    
    private int score;
    private boolean passe;
    private Goban goban;
    private int nbPierresCapturees;
    
    /**
     * Constructeur par défault de Joueur, initialise la valeur de score à 0.
     */
    public Joueur(){
        score=0;
        this.goban = null;
        this.passe = false;
        nbPierresCapturees=0;
    }
    
    /**
     * Constructeur permettant la création d'un joueur ayant un score déterminé
     * @param a 
     */
    public Joueur(int a){
        score=a;
        this.goban = null;
        this.passe = false;
        nbPierresCapturees=0;
    }
    
    public Joueur (Goban g){
        this();
        this.goban=g;
    }
    public Joueur (int a, Goban g){
        this(a);
        this.goban=g;
    }

    public int getNbPierresCapturees() {
        return nbPierresCapturees;
    }

    public void setNbPierresCapturees(int nbPierresCapturees) {
        this.nbPierresCapturees = nbPierresCapturees;
    }
    /**
     * Permet d'accéder à la valeur de score
     * @return 
     */
    public int getScore() {
        return score;
    }

    /**
     * Permet de modifier la valeur de score
     * @param score 
     */
    public void setScore(int score) {
        this.score = score;
    }
    public void setPasse(boolean p){
        this.passe = p;
    }
    
   /**
    * Permet au joueur de jouer une pierre, en attribuant un joueur à une case du plateau
    * @param pos 
    */
    public void ajoutPierre(Case pos){
        pos.setJoueur(this);
    }
    
    public void jouer(){
        if(!passe){
            ajoutPierre(choixCase());
        }
    }
    public Case choixCase(){
        Scanner console = new Scanner(System.in);
        System.out.println("Entrez l'abscisse de la case");
        int a = console.nextInt();
        System.out.println("Entrez l'ordonnée de la case");
        int b = console.nextInt();
        Case c = new Case(a, b, goban);
        return c;
    }
}
