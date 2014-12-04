/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plateau;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabien
 */
public class Case {
    private int x;
    private int y;
    private Joueur p;
    /**
     * Constructeur de base de la classe Case, prenant deux entier en paramètres
     * @param x : abscisse
     * @param y : ordonnée
     */
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.p = null;
    }
    /**
     * Constructeur de recopie de la classe Case
     * @param a : la Case à recopier
     */
    public Case(Case a){
        this.x=a.x;
        this.y=a.y;
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
    public Joueur getP() {
        return p;
    }
    /**
     * Méthode retournant l'ordonnée de la case
     * @return l'ordonnée sous forme d'un entier
     */
    public int getY() {
        return y;
    }
}
