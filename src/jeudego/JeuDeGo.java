/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudego;
import plateau.Goban;
import Affichage.*;
/**
 *
 * @author Fabien
 */
public class JeuDeGo {
    static final int SIZE = 9;
    private JeuDeGo(){
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Goban g = new Goban(SIZE);
        g.tourDeJeu();
    }
    
}
