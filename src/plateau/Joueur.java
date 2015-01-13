/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package plateau;

import java.util.ArrayList;
import java.util.List;
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
    }
    
   /**
    * Permet au joueur de jouer une pierre, en attribuant un joueur à une case du plateau
    * @param pos 
    */
    public void ajoutPierre(Case pos){
        pos.setJoueur(this);
        List<Groupe> grps = (ArrayList)pos.getGroupesAdjacents();
        goban.addGroupe(pos);
        for (Groupe g : grps){
            if (((ArrayList<Case>)g.getPierres()).get(0).getJoueur().equals(this)){
                pos.getGroupe().absorbGroupe(g);
            }
        }
    }
    
    public void jouer(){
        System.out.println("Joueur " + couleur);
        Scanner console = new Scanner(System.in);
        String s = "";
        this.setPasse(false);
        do{
            do{
                System.out.println("Souhaitez-vous passer ? o/n");
                s = console.nextLine();
            }while (!"n".equals(s) && !"o".equals(s));
            this.setPasse("o".equals(s));
            s = "";
            if(!passe){
                Case c = choixCase();
                if (c != null){
                    ajoutPierre(c);
                    for (int i = 0 ; i < goban.getGroupes().size(); i++){
                        if (goban.getGroupes().get(i).isCapture()){
                            goban.getGroupes().get(i).pierresCapturees();
                            i--;
                        }
                    }
                    goban.resetPasse();
                        break;
                }
            } else {
                goban.incrPasse();
            }
        } while(!this.passe);
    }
    
    public Case choixCase(){
        Case c;
        Scanner console = new Scanner(System.in);
        System.out.println("Entrez l'abscisse de la case");
        int a,b;
        try{
            a = Integer.parseInt(console.nextLine());
        } catch (NumberFormatException e) {
            a = -1;
        }
        System.out.println("Entrez l'ordonnée de la case");
        try{
            b = Integer.parseInt(console.nextLine());
        } catch (NumberFormatException e) {
            b = -1;
        }
        
        c = goban.getCase(a, b);
        if (c == null || c.getJoueur() != null || goban.isSuicide(c, this)){
            System.out.println("Cette case n'est pas disponible.");
            c = null;
        }
        return c;
    }
}
