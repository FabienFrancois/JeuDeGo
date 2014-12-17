/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Affichage;
import Plateau.*;
/**
 *
 * @author akagami
 */
public class AffichageConsole {
    
    private Goban g;
    
    public AffichageConsole(Goban gob){
        g = gob;
    }
    
    public void affichePlateau(){
        for (int i = 0; i < g.getTaille(); i++){
            for (int j = 0; j < g.getTaille(); j++){
                System.out.print("|");
                if (g.getCase(i, j).caseLibre()){
                    System.out.print("_");
                } else if (g.getCase(i, j).getJoueur().getCouleur().equals(Couleur.Blanc)){
                    System.out.print("o");
                } else {
                    System.out.print("x");
                }
            }
            System.out.println("|");
        }
    }
}
