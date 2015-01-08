/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plateau;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fabien
 */
public class GroupeTest {
    
    public GroupeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    /**
     * Test of getLiberte method, of class Groupe.
     */
    @Test
    public void testGetLiberte() {
        Goban g = new Goban(9);
        g.getPlayer1().ajoutPierre(g.getCase(1, 1));
        g.getPlayer1().ajoutPierre(g.getCase(2, 2));
        g.getPlayer1().ajoutPierre(g.getCase(1, 3));
        g.getPlayer1().ajoutPierre(g.getCase(0, 2));
        g.getPlayer1().ajoutPierre(g.getCase(0, 4));
        g.getPlayer2().ajoutPierre(g.getCase(0, 3));
        g.getPlayer2().ajoutPierre(g.getCase(1, 2));
        g.getPlayer2().ajoutPierre(g.getCase(8, 8));
        g.getPlayer2().ajoutPierre(g.getCase(8, 7));
        g.getPlayer2().ajoutPierre(g.getCase(7, 8));
        Groupe gr1 = new Groupe(g);
        Groupe gr2 = new Groupe();
        gr2.setGoban(g);
        Groupe gr3 = new Groupe(g);
        Groupe gr4 = new Groupe(g);
        gr4.addPierre(g.getCase(5, 5));
        Groupe gr5 = new Groupe(g);
        gr5.addPierre(g.getCase(8, 8));
        gr5.addPierre(g.getCase(7, 8));
        gr5.addPierre(g.getCase(8, 7));
        gr3.addPierre(g.getCase(2, 3));
        gr1.addPierre(g.getCase(1, 2));
        gr2.addPierre(g.getCase(0, 3));
        assertEquals(0, gr1.getLiberte().size());
        assertEquals(0, gr2.getLiberte().size());
        assertEquals(2, gr3.getLiberte().size());
        assertEquals(4, gr4.getLiberte().size());
        assertEquals(3, gr5.getLiberte().size());
    }

    /**
     * Test of isCapture method, of class Groupe.
     */
    @Test
    public void testIsCapture() {
        Goban g = new Goban(9);
        g.getPlayer1().ajoutPierre(g.getCase(1, 1));
        g.getPlayer1().ajoutPierre(g.getCase(2, 2));
        g.getPlayer1().ajoutPierre(g.getCase(1, 3));
        g.getPlayer1().ajoutPierre(g.getCase(0, 2));
        g.getPlayer1().ajoutPierre(g.getCase(0, 4));
        g.getPlayer2().ajoutPierre(g.getCase(0, 3));
        g.getPlayer2().ajoutPierre(g.getCase(1, 2));
        g.getPlayer1().ajoutPierre(g.getCase(6, 8));
        g.getPlayer1().ajoutPierre(g.getCase(7, 7));
        g.getPlayer1().ajoutPierre(g.getCase(8, 6));
        g.getPlayer2().ajoutPierre(g.getCase(8, 8));
        g.getPlayer2().ajoutPierre(g.getCase(8, 7));
        g.getPlayer2().ajoutPierre(g.getCase(7, 8));
        Groupe gr1 = new Groupe(g);
        Groupe gr2 = new Groupe();
        gr2.setGoban(g);
        Groupe gr3 = new Groupe(g);
        Groupe gr4 = new Groupe(g);
        gr4.addPierre(g.getCase(5, 5));
        Groupe gr5 = new Groupe(g);
        gr5.addPierre(g.getCase(8, 8));
        gr5.addPierre(g.getCase(7, 8));
        gr5.addPierre(g.getCase(8, 7));
        gr3.addPierre(g.getCase(2, 3));
        gr1.addPierre(g.getCase(1, 2));
        gr2.addPierre(g.getCase(0, 3));
        assertTrue(gr1.isCapture());
        assertTrue(gr2.isCapture());
        assertFalse(gr3.isCapture());
        assertFalse(gr4.isCapture());
        assertTrue(gr5.isCapture());
    }

    /**
     * Test of pierresCapturees method, of class Groupe.
     */
    @Test
    public void testPierresCapturees() {
        Goban g = new Goban(9);
        g.getPlayer1().ajoutPierre(g.getCase(1, 1));
        g.getPlayer1().ajoutPierre(g.getCase(2, 2));
        g.getPlayer1().ajoutPierre(g.getCase(1, 3));
        g.getPlayer1().ajoutPierre(g.getCase(0, 2));
        g.getPlayer1().ajoutPierre(g.getCase(0, 4));
        g.getPlayer2().ajoutPierre(g.getCase(0, 3));
        g.getPlayer2().ajoutPierre(g.getCase(1, 2));
        g.getPlayer1().ajoutPierre(g.getCase(5, 5));
        g.getPlayer2().ajoutPierre(g.getCase(5, 6));
        g.getPlayer2().ajoutPierre(g.getCase(5, 4));
        g.getPlayer2().ajoutPierre(g.getCase(6, 5));
        g.getPlayer2().ajoutPierre(g.getCase(4, 5));
        g.getPlayer1().ajoutPierre(g.getCase(6, 8));
        g.getPlayer1().ajoutPierre(g.getCase(7, 7));
        g.getPlayer1().ajoutPierre(g.getCase(8, 6));
        g.getPlayer2().ajoutPierre(g.getCase(8, 8));
        g.getPlayer2().ajoutPierre(g.getCase(8, 7));
        g.getPlayer2().ajoutPierre(g.getCase(7, 8));
        Groupe gr1 = new Groupe(g);
        gr1.addPierre(g.getCase(1, 2));
        Groupe gr2 = new Groupe();
        gr2.setGoban(g);
        Groupe gr3 = new Groupe(g);
        Groupe gr4 = new Groupe(g);
        gr4.addPierre(g.getCase(5, 5));
        gr3.addPierre(g.getCase(2, 3));
        gr2.addPierre(g.getCase(0, 3));
        Groupe gr5 = new Groupe(g);
        gr5.addPierre(g.getCase(8, 8));
        gr5.addPierre(g.getCase(7, 8));
        gr5.addPierre(g.getCase(8, 7));
        gr1.pierresCapturees();
        gr2.pierresCapturees();
        gr3.pierresCapturees();
        gr4.pierresCapturees();
        gr5.pierresCapturees();
        assertEquals(5,g.getPlayer1().getNbPierresCapturees());
        assertEquals(1,g.getPlayer2().getNbPierresCapturees());
    }

    /**
     * Test of absorbGroupe method, of class Groupe.
     */
    @Test
    public void testAbsorbGroupe() {
        Goban g = new Goban(9);
        g.getCase(1, 1).setJoueur(g.getPlayer1());
        g.getCase(1, 2).setJoueur(g.getPlayer1());
        g.getCase(1, 3).setJoueur(g.getPlayer1());
        g.getCase(1, 4).setJoueur(g.getPlayer1());
        g.getCase(1, 5).setJoueur(g.getPlayer1());
        g.getCase(2, 2).setJoueur(g.getPlayer1());
        g.getCase(0, 2).setJoueur(g.getPlayer1());
        g.addGroupe(g.getCase(1, 1));
        g.addGroupe(g.getCase(2, 2));
        g.addGroupe(g.getCase(1, 3));
        g.addGroupe(g.getCase(0, 2));
        g.addGroupe(g.getCase(1, 5));
        g.addGroupe(g.getCase(1, 2));
        g.addGroupe(g.getCase(1, 4));
        assertEquals(7, g.getGroupes().size());
        ArrayList<Groupe> grps = g.getCase(1, 4).getGroupesAdjacents();
        for (Groupe gr : grps){
            g.getCase(1, 4).getGroupe().absorbGroupe(gr);
        }
        assertEquals(5, g.getGroupes().size());
        ArrayList<Groupe> grpsbis = g.getCase(1, 2).getGroupesAdjacents();
        for (Groupe gr : grpsbis){
            g.getCase(1, 2).getGroupe().absorbGroupe(gr);
        }
        assertEquals(1, g.getGroupes().size());
    }
    
}
