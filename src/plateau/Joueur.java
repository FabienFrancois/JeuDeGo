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
    /**
     * Constructeur permettant de définir la couleur du joueur.
     * @param coul de type Couleur : La couleur du joueur créé.
     */
    public Joueur(Couleur coul){
        score=0;
        this.goban = null;
        this.passe = false;
        nbPierresCapturees=0;
        couleur = coul;
    }
    /**
     * Constructeur permettant la création d'un joueur ayant un score déterminé.
     * @param a de type Integer : Le score du joueur créé.
     */
    public Joueur(int a){
        score=a;
        this.goban = null;
        this.passe = false;
        nbPierresCapturees=0;
        couleur = null;
    }
    
    /**
     * Constructeur permettant la création d'un joueur ayant un score et une couleur déterminés.
     * @param a de type Integer : Le score du joueur créé.
     * @param coul de type Couleur : La couleur du joueur créé.
     */
    public Joueur(int a, Couleur coul){
        score=a;
        this.goban = null;
        this.passe = false;
        nbPierresCapturees=0;
        couleur = coul;
    }
    /**
     * Constructeur permettant d'associer un plateau de jeu au joueur créé.
     * @param g de type Goban : Le plateau de jeu associé au joueur.
     */
    public Joueur (Goban g){
        this();
        this.goban=g;
    }
    /**
     * Constructeur permettant d'associer un plateau de jeu et une couleur au joueur créé.
     * @param coul de type Couleur : La couleur du joueur créé.
     * @param g de type Goban : Le plateau de jeu associé au joueur.
     */
    public Joueur (Couleur coul, Goban g){
        this(coul);
        this.goban=g;
    }
    /**
     * Constructeur permettant d'associer un plateau de jeu et un score au joueur créé.
     * @param a de type Integer : Le score du joueur créé.
     * @param g de type Goban : Le plateau de jeu associé au joueur.
     */
    public Joueur (int a, Goban g){
        this(a);
        this.goban=g;
    }
    /**
     * Constructeur permettant d'associer un plateau de jeu, un score et une couleur au joueur créé.
     * @param a de type Integer : Le score du joueur créé.
     * @param coul de type Couleur : La couleur du joueur créé.
     * @param g de type Goban : Le plateau de jeu associé au joueur.
     */
    public Joueur (int a, Couleur coul, Goban g){
        this(a, coul);
        this.goban=g;
    }
    /**
     * Donne le nombre de pierres capturées par le joueur.
     * @return de type Integer : Le nombre de pierres capturées.
     */
    public int getNbPierresCapturees() {
        return nbPierresCapturees;
    }
    /**
     * Change le nombre de pierres capturées par le joueur.
     * @param nbPierresCapturees de type Integer : Le nouveau nombre de pierres.
     */
    public void setNbPierresCapturees(int nbPierresCapturees) {
        this.nbPierresCapturees = nbPierresCapturees;
    }
    /**
     * Permet d'accéder à la valeur de score.
     * @return de type Integer : Le score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Permet de modifier la valeur de score.
     * @param score de type Integer : La nouvelle valeur de score.
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * Renvoie la couleur du joueur.
     * @return de type Couleur : La couleur du joueur.
     */
    public Couleur getCouleur(){
        return couleur;
    }
    /**
     * Permet de modifier la valeur de passe.
     * @param p de type boolean : La nouvelle valeur.
     */
    public void setPasse(boolean p){
        this.passe = p;
    }
    
   /**
    * Permet au joueur de jouer une pierre, en attribuant un joueur à une case du plateau
    * @param pos de type Case : La position de la case où jouer la pierre.
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
    /**
     * Réalise le déroulement d'un tour de jeu pour le joueur.
     */
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
    /**
     * Permet au joueur de choisir la case où jouer sa pierre.
     * @return de type Case : La case sélectionnée.
     */
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
