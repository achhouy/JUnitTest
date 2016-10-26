/*
 * TCSS 305 - Winter 2016
 * Assignment 1 - Testing
 */

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Point;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that tests the Circle Class to make 
 * sure it is functioning correctly.
 * 
 * @author Arrunn Chhouy
 * @version 1.2
 *
 */
public class CircleTest {
    
    /** A tolerance used when comparing double values for equality. */
    private static final double TOLERANCE = .000001;
    
    
    /** A Circle to use in the tests. "Test fixture". */
    private Circle myCircle;
    
    
    /**
     * 
     *@throws java.lang.Exception if there are condition that need to
     * caught.
     */
    @Before
    public void setUp() throws Exception {
        myCircle = new Circle();
    }

    /**
     * Test method for {@link Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test
    public void testCircleDoublePointColor() {
        final Point p1 = new Point(3, 4);
        final Circle c1 = new Circle(6 , p1 , Color.RED);
        
        assertEquals(6, c1.getRadius(), TOLERANCE);
        assertEquals(p1, c1.getCenter());
        assertEquals(Color.RED, c1.getColor());   
    }
    
    /**
     * Test method for {@link Circle#Circle(double, java.awt.Point, java.awt.Color)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testOverloadNegativeRadius() {
        final Point p1 = new Point(7, 8);
        final Circle c1 = new Circle(-15 , p1 , Color.RED);
        assertEquals(-15, c1.getRadius(), TOLERANCE);
    }
    

    /**
     * Test method for {@link Circle#Circle()}.
     */
    @Test
    public void testCircle() {
        final Point test = new Point(0, 0);
        assertEquals(1.0, myCircle.getRadius(), TOLERANCE);
        assertEquals(test, myCircle.getCenter());
        assertEquals(Color.BLACK, myCircle.getColor());
    }

    /**
     * Test method for {@link Circle#setRadius(double)}.
     */
    @Test
    public void testSetRadius() {
        myCircle.setRadius(12);
        assertEquals(12 , myCircle.getRadius(), TOLERANCE);
    }
    
    /**
     * Test method for {@link Circle#setRadius(double)}.
     * Checks to see if there are negative values being passed.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetRadiusNegative() {
        myCircle.setRadius(-23);
        assertEquals(12 , myCircle.getRadius(), TOLERANCE);
    }
    
    /**
     * Test method for {@link Circle#setRadius(double)}.
     * Checks to see if there are negative values being passed.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetRadiusZero() {
        myCircle.setRadius(0);
        assertEquals(12 , myCircle.getRadius(), TOLERANCE);
    }

    /**
     * Test method for {@link Circle#setCenter(java.awt.Point)}.
     */
    @Test
    public void testSetCenter() {
        final Point pointTester = new Point(3, 3);
        myCircle.setCenter(pointTester);
        assertEquals(pointTester, myCircle.getCenter());
    }

    /**
     * Test method for {@link Circle#setCenter(java.awt.Point)}.
     * Test to see if the value passed is null
     */
    @Test (expected = NullPointerException.class)
    public void testSetCenterNull() {
        myCircle.setCenter(null);
    }
    
    /**
     * Test method for {@link Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColor() {
        myCircle.setColor(Color.BLUE);
        assertEquals(Color.BLUE, myCircle.getColor());
    }
    
    /**
     * Test method for {@link Circle#setColor(java.awt.Color)}.
     */
    @Test (expected = NullPointerException.class)
    public void testSetColorNull() {
        myCircle.setColor(null);
    }

    /**
     * Test method for {@link Circle#getRadius()}.
     */
    @Test
    public void testGetRadius() {
        assertEquals(1.0 , myCircle.getRadius(), TOLERANCE);
    }

    /**
     * Test method for {@link Circle#getCenter()}.
     */
    @Test
    public void testGetCenter() {
        final Point pointTester = new Point(0, 0);
        assertEquals(pointTester, myCircle.getCenter());
    }

    /**
     * Test method for {@link Circle#getColor()}.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.BLACK, myCircle.getColor());
    }

    /**
     * Test method for {@link Circle#calculateDiameter()}.
     */
    @Test
    public void testCalculateDiameter() {
        myCircle.setRadius(5);
        final double result = 2 * myCircle.getRadius();
        assertEquals(result, myCircle.calculateDiameter(), TOLERANCE);
    }

    /**
     * Test method for {@link Circle#calculateCircumference()}.
     */
    @Test
    public void testCalculateCircumference() {
        myCircle.setRadius(34);
        final double result = 2 * Math.PI * myCircle.getRadius();
        assertEquals(result, myCircle.calculateCircumference(), TOLERANCE);
    }

    /**
     * Test method for {@link Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea() {        
        myCircle.setRadius(11);
        final double result = Math.PI * Math.pow(11, 2);
        assertEquals(result, myCircle.calculateArea(), TOLERANCE);        
    }

    /**
     * Test method for {@link Circle#toString()}.
     */
    @Test
    public void testToString() {
        myCircle.setRadius(56);
        final String testResult = "Circle [radius=56.00,"
                          + " center=java.awt.Point[x=0,y=0], "
                          + "color=java.awt.Color[r=0,g=0,b=0]]";
        assertEquals(testResult, myCircle.toString());
    }

}
