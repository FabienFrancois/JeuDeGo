/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Plateau;

import java.util.ArrayList;
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
    private Couleur couleur;
    
    /**
     * Constructeur par défault de Joueur, initialise la valeur de score à 0.
     */
    public Joueur(){
        score=0;
        this.goban = null;
        this.passe = false;
        nbPierresCapturees=0;
        couleur = null;
    }
    
    public Joueur(Couleur coul){
        score=0;
        this.goban = null;
        this.passe = false;
        nbPierresCapturees=0;
        couleur = coul;
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
        couleur = null;
    }
    
    /**
     * Constructeur permettant la création d'un joueur ayant un score déterminé
     * @param a 
     * @param coul 
     */
    public Joueur(int a, Couleur coul){
        score=a;
        this.goban = null;
        this.passe = false;
        nbPierresCapturees=0;
        couleur = coul;
    }
    
    public Joueur (Goban g){
        this();
        this.goban=g;
    }
    public Joueur (Couleur coul, Goban g){
        this(coul);
        this.goban=g;
    }
    public Joueur (int a, Goban g){
        this(a);
        this.goban=g;
    }
    public Joueur (int a, Couleur coul, Goban g){
        this(a, coul);
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
    
    public Couleur getCouleur(){
        return couleur;
    }
    
    public void setPasse(boolean p){
        this.passe = p;
        if (p){
            goban.incrPasse();
        } else {
            goban.resetPasse();
        }
    }
    
   /**
    * Permet au joueur de jouer une pierre, en attribuant un joueur à une case du plateau
    * @param pos 
    */
    public void ajoutPierre(Case pos){
        pos.setJoueur(this);
        ArrayList<Groupe> grps = pos.getGroupesAdjacents();
        goban.addGroupe(pos);
        for (Groupe g : grps){
            if (g.getPierres().get(0).getJoueur().equals(this)){
                pos.getGroupe().absorbGroupe(g);
            } else {
            }
        }
    }
    
    public void jouer(){
        System.out.println("Joueur " + couleur);
        Scanner console = new Scanner(System.in);
        String s = "";
        do{
            System.out.println("Souhaitez-vous passer ? o/n");
            s = console.nextLine();
        }while (!"n".equals(s) && !"o".equals(s));
        this.setPasse("o".equals(s));
        if(!passe){
            ajoutPierre(choixCase());
            for (Groupe g : goban.getGroupes()){
                g.pierresCapturees();
            }
        }
    }
    public Case choixCase(){
        Case c;
        do{
            Scanner console = new Scanner(System.in);
            System.out.println("Entrez l'abscisse de la case");
            int a = console.nextInt();
            System.out.println("Entrez l'ordonnée de la case");
            int b = console.nextInt();
            c = goban.getCase(a, b);
            if (c.getJoueur() != null){
                System.out.println("Cette case est occupée, veuillez en sélectionner une autre.");
            }
        } while(c.getJoueur() != null);
        return c;
    }
}
