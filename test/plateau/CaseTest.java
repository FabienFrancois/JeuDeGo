package plateau;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antoine
 */
public class CaseTest {
    
    public CaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
 


    /**
     * Test of caseLibre method, of class Case.
     */
    @Test
    public void testCaseLibre() {
        System.out.println("CaseLibre");
        Case c=new Case(1,3);
        assertEquals(true,c.caseLibre());    
    }

    /**
     * Test of caseJouable method, of class Case.
     */
    @Test
    public void testCaseJouable() {
        Goban g=new Goban(9);
        
        g.getCase(1, 1).setJoueur(g.getPlayer1());
        g.getCase(2, 1).setJoueur(g.getPlayer1());
        g.getCase(1, 2).setJoueur(g.getPlayer1());
        g.getCase(3, 3).setJoueur(g.getPlayer1());
        g.getCase(3, 2).setJoueur(g.getPlayer1());
        g.getCase(2, 3).setJoueur(g.getPlayer1());
        
        assertEquals(false,g.getCase(2, 2).caseJouable());
        assertEquals(false,g.getCase(1, 1).caseJouable());
        assertEquals(true,g.getCase(4, 1).caseJouable());
    }

    /**
     * Test of nombreLibertésAutourDe method, of class Case.
     */
    @Test
    public void testNombreLibertésAutourDe() {
        Goban g=new Goban(9);
        
        g.getCase(1, 1).setJoueur(g.getPlayer1());
        g.getCase(2, 1).setJoueur(g.getPlayer1());
        g.getCase(1, 2).setJoueur(g.getPlayer1());
        g.getCase(3, 3).setJoueur(g.getPlayer1());
        g.getCase(3, 2).setJoueur(g.getPlayer1());
        g.getCase(2, 3).setJoueur(g.getPlayer1());
        
        assertEquals(2,g.getCase(8,8).nombreLibertésAutourDe());
        assertEquals(0,g.getCase(2, 2).nombreLibertésAutourDe());
        assertEquals(4,g.getCase(5,5).nombreLibertésAutourDe());
    }
    
}