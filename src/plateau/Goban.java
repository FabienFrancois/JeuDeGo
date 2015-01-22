/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateau;

import affichage.AffichageConsole;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe décrivant le goban.
 * @author Fabien
 */
public class Goban {
    private int taille;
    private Case[][] cases;
    private List<Groupe> groupes;
    private Joueur player1;
    private Joueur player2;
    private int passe;
    private static final int NUMBER_OF_PLAYERS = 2;
    /**
     * Constructeur qui crée un plateau de taille déterminée par l'utilisateur.
     * @param taille de type Integer : la taille du plateau.
     */
    public Goban(int taille){
        this.taille=taille;
        passe = 0;
        cases = new Case[taille][taille];
        for (int i=0; i<taille; i++){
            for (int j=0; j<taille; j++){
                cases[i][j]=new Case(i,j,this);
            }
        }
        this.player1 = new Joueur(Couleur.NOIR, this);
        this.player2 = new Joueur(Couleur.BLANC, this);
        groupes = new LinkedList<>();
    }
    /**
     * Permet de changer la case en position i,j sur le goban.
     * @param i de type Integer : abscisse de la case.
     * @param j de type Integer : ordonnée de la case.
     * @param p de type Case : la nouvelle case.
     */
    public void setCase(int i, int j, Case p){
        this.cases[i][j]=p;
    }
    /**
     * Méthode retournant la taille du goban.
     * @return de type Integer : taille.
     */
    public int getTaille() {
        return taille;
    }
    /**
     * Méthode renvoyant le Joueur 1.
     * @return de type Joueur : Le joueur 1.
     */
    public Joueur getPlayer1() {
        return player1;
    }
    /**
     * Méthode renvoyant le Joueur 2.
     * @return de type Joueur : Le joueur 2.
     */
    public Joueur getPlayer2() {
        return player2;
    }
    
    /**
     * Méthode retournant la case située en i, j sur le plateau.
     * @param i de type Integer : abscisse de la case.
     * @param j de type Integer : ordonnée de la case.
     * @return de type Case : la Case en question.
     */
    public Case getCase(int i, int j){
        Case c = null;
        if (i>=0 && j>=0 && i<taille && j<taille){
            c = cases[i][j];
        }
        return c;
    }
    
    /**
     * Permet de déterminer si une case est en dehors du plateau de jeu.
     * @param a de type Integer : L'abscisse de la case.
     * @param b de type Integer : L'ordonnée de la case.
     * @return de type boolean : true si la case est en dehors du plateau.
     */
    public boolean horsPlateau(int a, int b){
        return !(a>=0 && a<taille && b>=0 && b<taille);
    }
    /**
     * Permet d'accéder aux cases autour d'une case.
     * @param pos de type Case : La case étudiée.
     * @return de type List<Case> : La liste des cases autour de pos.
     */
    public List<Case> getCasesAutourDe(Case pos){
        List<Case> a= new ArrayList<>();
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
    /**
     * Permet d'accéder aux groupes du plateua de jeu.
     * @return de type List<Groupe> : La liste des groupes du plateau.
     */
    public List<Groupe> getGroupes() {
        return groupes;
    }
    /**
     * Détermine si une pierre est dans un groupe du plateau.
     * @param c de type Case : La pierre étudiée.
     * @return de type boolean : true si la pierre est dans un groupe.
     */
    public boolean isDansGroupe(Case c){
        for (Groupe g : (ArrayList<Groupe>)groupes){
            if (g.getPierres().contains(c)){
                return true;
            }
        }
        return false;
    }
    /**
     * Supprime un groupe de la liste des groupes.
     * @param g de type Groupe : Le groupe à supprimer.
     */
    public void retirerGroupe(Groupe g){
        groupes.remove(g);
    }
    /**
     * Ajoute un groupe à la liste des groupes.
     * @param p de type Groupe : Le groupe à ajouter.
     */
    public void addGroupe(Case p){
        Groupe g = new Groupe(this);
        g.addPierre(p);
        groupes.add(g);
    }
    /**
     * Lance une partie de jeu de go sur ce plateau.
     */
    public void tourDeJeu(){
        AffichageConsole aff = new AffichageConsole(this);
        aff.affichePlateau();
        int compteur = 0;
        do{
            if (compteur == 0){
                player1.jouer();
                compteur++;
            } else {
                player2.jouer();
                compteur--;
            }
            aff.affichePlateau();
        }while (passe < NUMBER_OF_PLAYERS);
    }
    /**
     * Détermine si une pierre jouée sur une certaine case correspond à un suicide.
     * @param pos de type Case : La case à tester.
     * @param j de type Joueur : Le joueur concerné.
     * @return de type boolean : true si il s'agit d'un suicide.
     */
    public boolean isSuicide(Case pos, Joueur j){
        Groupe g  = new Groupe(this);
        g.addPierre(pos);
        for(Groupe g1 : pos.getGroupesAdjacents()){
            if(((ArrayList<Case>)g1.getPierres()).get(0).getJoueur().equals(j)){
                (g.getPierres()).addAll(g1.getPierres());
            }
        }
        List<Case> lib = (ArrayList<Case>)g.getLiberte();
        lib.remove(pos);
        List<Groupe> grps = pos.getGroupesAdjacents();
        boolean b = grps.size()== 1 && grps.get(0).getPierres().get(0).getJoueur() != j && pos.nombreLibertesAutourDe() == 0 && 
                grps.get(0).getLiberte().size() == 1;
        // b est vrai si la case est entièrement entourée par un seul groupe, si ce groupe appartient au joueur enemi,
        // et si ce groupe n'a qu'une liberté.
        return lib.isEmpty() && !b;
    }
    /**
     * Augmente le compteur du nombre de joueurs successifs ayant passé leur tour.
     */
    public void incrPasse(){
        passe++;
    }
    /**
     * Réinitialise le nombre de joueurs successifs ayant passé leur tour.
     */
    public void resetPasse(){
        passe = 0;
    }
}
