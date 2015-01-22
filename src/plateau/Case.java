/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateau;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
     * Constructeur de base de la classe Case, prenant deux entier en paramètres.
     * @param x de type Integer : abscisse.
     * @param y de type Integer : ordonnée.
     */
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.p = null;
        this.g = null;
    }
    /**
     * Constructeur avec le plateau de jeu.
     * @param x de type Integer : Abscisse.
     * @param y de type Integer : Ordonnée.
     * @param g de type Integer : Plateau de jeu.
     */
    public Case(int x, int y, Goban g) {
        this.x = x;
        this.y = y;
        this.p = null;
        this.g = g;
    }
    /**
     * Constructeur de recopie de la classe Case.
     * @param a de type Case: la Case à recopier.
     */
    public Case(Case a){
        this.x= a.getX();
        this.y= a.getY();
        this.p = a.getJoueur();
        this.g = a.getGoban();
    }
    /**
     * Méthode retournant l'abscisse de la case.
     * @return de type Integer : l'abscisse sous forme d'un entier.
     */
    public int getX() {
        return x;
    }
    /**
     * Méthode retournant le joueur auquel appartient la pierre posée sur la case.
     * Si aucune pierre n'est posée, le joueur est null.
     * @return de type Joueur : le joueur en question.
     */
    public Joueur getJoueur() {
        return p;
    }
    /**
     * Méthode retournant l'ordonnée de la case.
     * @return de type Integer : l'ordonnée sous forme d'un entier.
     */
    public int getY() {
        return y;
    }
    /**
     * Méthode retournant le plateau de jeu de la case.
     * @return de type Goban : le plateau de jeu.
     */
    public Goban getGoban(){
        return g;
    }
    /**
     * Méthode permettant de changer le joueur qui contrôle la case.
     * @param p de type Joueur : Le joueur contrôlant la case.
     */
    public void setJoueur(Joueur p){
        this.p=p;
    }
    /**
     * Méthode permettant d'accéder au plateau sur lequel se situe la case.
     * @param g de type Goban : Le plateau.
     */
    public void setGoban(Goban g){
        this.g = g;
    }
    
    /**
     * Permet de savoir si une case est libre ou pas (si il y a déjà une pierre dessus).
     * @return de type boolean : true si la case est libre.
     */
    public boolean caseLibre(){
        return this.p==null;
    }
    /**
     * Permet de savoir si unepierre peut être posée sur la case.
     * @return de type boolean : true si la case est jouable.
     */
    public boolean caseJouable(){
        boolean a;
        a=(caseLibre()&&!(this.g.horsPlateau(this.x,this.y)));
        if(nombreLibertesAutourDe()<1){
            a=false;
        }
        return a;
    }
    /**
     * Donne le nombre de liberté autour de la case.
     * @return de type Integer : Le nombre de libertés de la case.
     */
    public int nombreLibertesAutourDe() {
        int n=0;
        List<Case> a = (ArrayList<Case>)g.getCasesAutourDe(this);
        for (Case a1 : a) {
            if (a1.caseLibre()) {
                n++;
            }
        }
        return n;
    }
    /**
     * Donne le groupe dans lequel est située la case. Si elle n'est dans aucun groupe,
     * la méthode renvoie null.
     * @return de type Groupe : Le groupe contenant la case.
     */
    public Groupe getGroupe(){
        for (Groupe grp : g.getGroupes()){
            if (((ArrayList<Case>)grp.getPierres()).contains(this)){
                return grp;
            }
        }
        return null;
    }
    /**
     * Donne les groupes adjacents à une case.
     * @return de type List<Groupe> : La liste des groupes adjacents à la case.
     */
    public List<Groupe> getGroupesAdjacents(){
        Set<Groupe> groupes = new HashSet<>();
        List<Case> cases = (ArrayList<Case>)g.getCasesAutourDe(this);
        for (Case c : cases){
            if (c.getGroupe() != null) {
                groupes.add(c.getGroupe());
            }
        }
        return (List)new ArrayList<>(groupes);
    }
    
    
    
}
