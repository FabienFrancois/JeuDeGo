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
        g.tourDeJeu();
    }
    
}
