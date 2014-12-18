/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plateau;

/**
 *
 * @author akagami
 */
public enum Couleur {
    Blanc ("Blanc"),
    Noir ("Noir");
    
    private String name = "";
   
    //Constructeur
    Couleur(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
