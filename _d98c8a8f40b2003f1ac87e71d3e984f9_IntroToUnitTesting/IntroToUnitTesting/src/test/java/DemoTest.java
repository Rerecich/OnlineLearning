import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayInputStream; 

import java.io.ByteArrayOutputStream; 

import java.io.PrintStream;  


import org.junit.Before; 


public class DemoTest {

	/***************TRIANGLES**************/
	@Test
	public void test_is_triangle_1() {
		assertTrue(Demo.isTriangle(3,4,5));
	}
	
	@Test
	public void test_is_triangle_2() {
		assertTrue(Demo.isTriangle(5,12,3));
	}
	
	@Test
	public void test_is_triangle_3() {
		assertTrue(Demo.isTriangle(12,5,13));
	}
	
	/***************NOT TRIANGLES**************/

	@Test
	public void test_is_NOT_triangle_1() {
		assertFalse(Demo.isTriangle(1,1,1));
	}
	
	@Test
	public void test_zero_edge_1() {
		assertFalse(Demo.isTriangle(0,1,1));
	}
	
	@Test
	public void test_zero_edge_2() {
		assertFalse(Demo.isTriangle(1,0,1));
	}
	
	@Test
	public void test_zero_edge_3() {
		assertFalse(Demo.isTriangle(1,1,0));
	}
	
	@Test
	public void test_wrong_dimensions_1() {
		assertFalse(Demo.isTriangle(1,2,3));
	}
	
	@Test
	public void test_wrong_dimensions_2() {
		assertFalse(Demo.isTriangle(3,1,2));
	}
	
	@Test
	public void test_wrong_dimensions_3() {
		assertFalse(Demo.isTriangle(3,2,1));
	}
	
	@Test
	public void test_negative_edge_1() {
		assertFalse(Demo.isTriangle(-3,4,5));
	}
	
	@Test
	public void test_negative_edge_2() {
		assertFalse(Demo.isTriangle(-3,4,5));
	}
	/***************I/O**************/

	@Test
	public void testInput_1 () {
		String input = "1\n"; //this doesn't actually input anything yet
		
		//to get user input in JUnit, need to redirect the system in and system out
		ByteArrayInputStream in = //data type for system in
					new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		//invoke main with empty string cuz we're not actually passing anything
		String[] args = {};
		Demo.main(args);

		//expected output
		String consoleOutput = "Enter side 1: \n";       
		consoleOutput += "Enter side 2: \n" ;       
		consoleOutput += "Enter side 3:\n" ;       
		consoleOutput +=  "This is a triangle. \n";       
		assertEquals(consoleOutput,out,toString());   
	}
}
