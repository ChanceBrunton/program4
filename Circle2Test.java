
/***
* Example JUnit testing class for Circle2 (and Circle)
*
* - must have your classpath set to include the JUnit jarfiles
* - to run the test do:
*     java org.junit.runner.JUnitCore Circle2Test
* - note that the commented out main is another way to run tests
* - note that normally you would not have print statements in
*   a JUnit testing class; they are here just so you see what is
*   happening. You should not have them in your test cases.
***/

import org.junit.*;

public class Circle2Test
{
   // Data you need for each test case
   private Circle2 circle2;
	private double TOLERANCE;

// 
// Stuff you want to do before each test case
//
@Before
public void setup()
{
   System.out.println("\nTest starting...");
   circle2 = new Circle2(1,2,3);
	TOLERANCE = 0.0001;
}

//
// Stuff you want to do after each test case
//
@After
public void teardown()
{
   System.out.println("\nTest finished.");
}

//
// Test a simple positive move
//
@Test
public void simpleMove()
{
   Point p;
   System.out.println("Running test simpleMove.");
   p = circle2.moveBy(1,1);
   Assert.assertTrue(p.x == 2 && p.y == 3);
}

// 
// Test a simple negative move
//
@Test
public void simpleMoveNeg()
{
   Point p;
   System.out.println("Running test simpleMoveNeg.");
   p = circle2.moveBy(-1,-1);
   Assert.assertTrue(p.x == 0 && p.y == 1);
}

//
// Test a simple expansion
//
@Test
public void testScaleExpand()
{
	double newRadius = circle2.scale(2);
	Assert.assertEquals(6,newRadius,TOLERANCE);
}

//
// Test a simple compression
//
@Test
public void testScaleCompression()
{
	double newRadius = circle2.scale(2);
	Assert.assertEquals(6,newRadius,TOLERANCE);
}

//
// Test an intersection
//
@Test
public void testIntersectionTrue()
{
	Circle2 circle2_2 = new Circle2(1,6,3);
	Assert.assertTrue(circle2.intersects(circle2_2));
}

//
// Test that two circles far apart do not intersect
//
@Test
public void testIntersectionOutside()
{
	Circle2 circle2_2 = new Circle2(1,12,3);
	Assert.assertFalse(circle2.intersects(circle2_2));
}
	
//
// Test that one circle inside another does not intersect
//
@Test
public void testIntersectionInside()
{
	Circle2 circle2_2 = new Circle2(1,2,1);
	Assert.assertFalse(circle2.intersects(circle2_2));
}

/*** NOT USED
public static void main(String args[])
{
   try {
      org.junit.runner.JUnitCore.runClasses(
               java.lang.Class.forName("Circle2Test"));
   } catch (Exception e) {
      System.out.println("Exception: " + e);
   }
}
***/

}

