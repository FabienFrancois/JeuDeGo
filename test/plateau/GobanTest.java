/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateau;

import plateau.Goban;
import plateau.Case;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fabien
 */
public class GobanTest {
    
    public GobanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of horsPlateau method, of class Goban.
     */
    @Test
    public void testHorsPlateau() {
        System.out.println("horsPlateau");
        Goban g = new Goban(9);
        assertTrue(g.horsPlateau(-1, 0));
        assertTrue(g.horsPlateau(0, -1));
        assertTrue(g.horsPlateau(-1, 15));
        assertTrue(g.horsPlateau(15, -1));
        assertTrue(g.horsPlateau(9, 3));
        assertTrue(g.horsPlateau(3, 20));
        assertFalse(g.horsPlateau(1, 1));
        assertFalse(g.horsPlateau(5, 4));
        assertFalse(g.horsPlateau(3, 6));
        assertFalse(g.horsPlateau(0, 8));
        assertFalse(g.horsPlateau(8, 0));
    }

    /**
     * Test of getCasesAutourDe method, of class Goban.
     */
    @Test
    public void testGetCasesAutourDe() {
        System.out.println("getCasesAutourDe");
        Goban g= new Goban(9);
        assertEquals(2, g.getCasesAutourDe(g.getCase(0,0)).size());
        assertEquals(4, g.getCasesAutourDe(g.getCase(2,3)).size());
        assertEquals(3, g.getCasesAutourDe(g.getCase(5,0)).size());
        ArrayList<Case> a= new ArrayList<>();
        a.add(g.getCase(1, 0));
        a.add(g.getCase(0, 1));
        assertEquals(a, g.getCasesAutourDe(g.getCase(0, 0)));
    }
    
}
