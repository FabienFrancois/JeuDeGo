/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Plateau;

/**
 *Représente un des deux joueurs
 * @author arigoure
 */
public class Joueur {
    
    private int score;
    
    /**
     * Constructeur par défault de Joueur, initialise la valeur de score à 0.
     */
    public Joueur(){
            score=0;
            }
    
    /**
     * Constructeur permettant la création d'un joueur ayant un score déterminé
     * @param a 
     */
    public Joueur(int a){
        score=a;
        
        
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
    
   /**
    * Permet au joueur de jouer une pierre, en attribuant un joueur à une case du plateau
    * @param pos 
    */
    public void ajoutPierre(Case pos){
        pos.setJoueur(this);
        
    }
}
