/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateau;

/**
 *
 * @author akagami
 */
public enum Couleur {
    BLANC ("Blanc"),
    NOIR ("Noir");
    
    private String name = "";
   
    //Constructeur
    Couleur(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
