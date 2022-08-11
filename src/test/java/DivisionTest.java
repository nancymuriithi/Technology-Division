import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
//    Test if division object is correctly created.
    @Test
    public void NewDivisionObjectGetsCorrectlyCreated_true() throws Exception {
        Division division = new Division("RNIO", "Power","James K.","Support Engineer","Checks on power maintenance works.");
        assertEquals(true, division instanceof Division);
    }

    @Test
    public void getCreated_isFalseAfterInstantiation_false() throws Exception {
        Division myDivision = new Division("RNIO", "Power","James K.","Support Engineer","Checks on power maintenance works.");
        assertEquals(false, myDivision.getCreated()); //should never start as created
    }
    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{
        Division.clearAllDivisions();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Division myDivision = new Division("RNIO", "Power","James K.","Support Engineer","Checks on power maintenance works.");
        assertEquals(1, myDivision.getId());
    }

//    @Test
//    public void findReturnsCorrectDivision() throws Exception {
//        Division division = setupNewDivision();
//        assertEquals(1, Division.findById(division.getId()).getId());
//    }
//
//    @Test
//    public void findReturnsCorrectDivisionWhenMoreThanOneDivisionExists() throws Exception {
//        Division division = setupNewDivision();
//        Division otherDivision = new Division("RNIO", "Power",1800,"James K.","Support Engineer","Checks on power maintenance works.");
//        assertEquals(2, Division.findById(otherDivision.getId()).getId());
//    }

    @Test
    public void getDepartment() {
    }

    @Test
    public void getSection() {
    }

    @Test
    public void getId() {
    }

    @Test
    public void getStaff() {
    }

    @Test
    public void getRole() {
    }

    @Test
    public void getResponsibilities() {
    }
}