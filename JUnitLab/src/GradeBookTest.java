import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * Starter JUnit 5 test class for GradeBook.
 * 
 * TODO for students:
 *  - Complete the test methods using appropriate assertions.
 *  - Add any additional tests you think are necessary.
 */
public class GradeBookTest
{
	
	private static final double DELTA = 0.0001;
	
    // Test fixtures: shared objects used in multiple tests
    private GradeBook g1;
    private GradeBook g2;

    /**
     * setUp runs BEFORE each @Test method.
     * Use it to create fresh GradeBook objects for every test.
     */
    @BeforeEach
    public void setUp() 
    {
        // TODO: initialize g1 and g2 with capacity 5
        // and add several scores to each using addScore

        g1 = new GradeBook(5);
        g1.addScore(50.0);
        g1.addScore(75.0);
        
        g2 = new GradeBook(5);
        g2.addScore(90.0);
        g2.addScore(85.0);
        g2.addScore(70.0);
    }

    /**
     * tearDown runs AFTER each @Test method.
     * Use it to clean up any objects if needed.
     */
    @AfterEach
    public void tearDown() 
    {
        g1 = null;
        g2 = null;
    }

    /**
     * Test addScore and toString.
     * 
     * Goal:
     *  - Verify that the scores are stored correctly.
     *  - Verify that toString returns the expected string
     *    (each score followed by a space, in the order added).
     */
    @Test
    public void testAddScoreAndToString() 
    {
        // TODO: write assertions that compare g1.toString() and g2.toString()
        
        assertEquals("50.0 75.0 ", g1.toString());
        assertEquals("90.0 85.0 70.0 ", g2.toString());
        assertEquals("", new GradeBook(5).toString());
    }
    
    /** I added a test for addScore to make sure 
       that it returns true until the gradebook is full
       and then returns false without changing the gradebook
    */
    @Test
    public void testAddScoreWhenFull() 
    {
        GradeBook small = new GradeBook(2);
        assertTrue(small.addScore(10.0));
        assertTrue(small.addScore(20.0));
        assertFalse(small.addScore(30.0));
        assertEquals(2, small.getScoreSize());
        assertEquals("10.0 20.0 ", small.toString());
    }

    /**
     * Test getScoreSize.
     * 
     * Goal:
     *  - Verify that getScoreSize returns the number of scores
     *    actually added to each GradeBook.
     */
    @Test
    public void testGetScoreSize() {
        // TODO: write assertions that check g1.getScoreSize() and g2.getScoreSize()
        
    	
    	assertEquals(2, g1.getScoreSize());
        assertEquals(3, g2.getScoreSize());
        assertEquals(0, new GradeBook(5).getScoreSize());
    }

    /**
     * Test sum.
     * 
     * Goal:
     *  - Verify that sum() returns the correct total of all scores.
     */
    @Test
    public void testSum() {
        // TODO: write assertions that check the sum of scores in g1 and g2

    	assertEquals(125.0, g1.sum(), DELTA);
        assertEquals(245.0, g2.sum(), DELTA);
    }

    /**
     * Test minimum.
     * 
     * Goal:
     *  - Verify that minimum() returns the smallest score.
     *  - Optionally test behavior when there are no scores.
     */
    @Test
    public void testMinimum() {
        // TODO: write assertions for minimum values in g1 and g2

    	assertEquals(50.0, g1.minimum(), DELTA);
        assertEquals(70.0, g2.minimum(), DELTA);

        // Optional: create a local empty GradeBook and test minimum() == 0
        GradeBook empty = new GradeBook(5);
        assertEquals(0.0, empty.minimum(), DELTA);
    }

    /**
     * Test finalScore.
     * 
     * Goal:
     *  - Verify that finalScore() drops the lowest score
     *    when there are at least two scores.
     *  - Verify behavior when there is exactly one score
     *    and when there are no scores.
     */
    @Test
    public void testFinalScore() {
        // TODO: write assertions for finalScore of g1 and g2
        // using the scores you added in setUp.
        //
        assertEquals(75.0, g1.finalScore(), DELTA);
        assertEquals(175.0, g2.finalScore(), DELTA);

        // TODO (optional but recommended): test special cases
        GradeBook empty = new GradeBook(5);
        assertEquals(0.0, empty.finalScore(), DELTA);
        //
        GradeBook single = new GradeBook(5);
        single.addScore(100.0);
        assertEquals(100.0, single.finalScore(), DELTA);
    }
}
