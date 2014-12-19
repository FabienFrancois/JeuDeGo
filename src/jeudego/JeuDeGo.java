/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;
import Plateau.*;
import Affichage.*;
/**
 *
 * @author Fabien
 */
public class JeuDeGo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Goban g = new Goban(9);
        g.getPlayer2().ajoutPierre(g.getCase(1, 0));
        g.getPlayer2().ajoutPierre(g.getCase(1, 1));
        g.getPlayer2().ajoutPierre(g.getCase(2, 1));
        g.getPlayer2().ajoutPierre(g.getCase(3, 1));
        g.getPlayer2().ajoutPierre(g.getCase(3, 0));
        g.getPlayer2().ajoutPierre(g.getCase(4, 1));
        g.getPlayer2().ajoutPierre(g.getCase(5, 1));
        g.getPlayer2().ajoutPierre(g.getCase(5, 0));
        g.getPlayer1().ajoutPierre(g.getCase(0, 0));
        g.getPlayer1().ajoutPierre(g.getCase(0, 1));
        g.getPlayer1().ajoutPierre(g.getCase(0, 2));
        g.getPlayer1().ajoutPierre(g.getCase(1, 2));
        g.getPlayer1().ajoutPierre(g.getCase(2, 2));
        g.getPlayer1().ajoutPierre(g.getCase(3, 2));
        g.getPlayer1().ajoutPierre(g.getCase(4, 2));
        g.getPlayer1().ajoutPierre(g.getCase(5, 2));
        g.getPlayer1().ajoutPierre(g.getCase(6, 2));
        g.getPlayer1().ajoutPierre(g.getCase(6, 1));
        g.getPlayer1().ajoutPierre(g.getCase(6, 0));
        g.tourDeJeu();
    }
    
}
