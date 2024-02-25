import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream; 
import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;
import java.util.InputMismatchException;


import org.junit.Before; 


public class DemoTest {

/***************TRIANGLES**************/

    /*Integers */
	@Test
	public void test_is_triangle_1() {
		assertTrue(Demo.isTriangle(3,4,5));
	}
	
	@Test
    public void test_is_triangle_2() {
    assertTrue(Demo.isTriangle(5, 12, 13));
    }

    @Test
    public void test_is_triangle_3() {
    assertTrue(Demo.isTriangle(8, 15, 17));
    }

    @Test
    public void test_is_triangle_4() {
    assertTrue(Demo.isTriangle(7, 24, 25));
    }

    @Test
    public void test_is_triangle_5() {
    assertTrue(Demo.isTriangle(9, 40, 41));
    }

    @Test
    public void test_is_triangle_6() {
    assertTrue(Demo.isTriangle(4, 3, 5));
    }

    @Test
    public void test_is_triangle_7() {
    assertTrue(Demo.isTriangle(5, 4, 3));
    }
	
/***************NOT TRIANGLES**************/
/*mutant versions - equality changes*/
    /*a + b = c */
    @Test
	public void F_EqualityIsNotTriangle_1() {
		assertFalse(Demo.isTriangle(1,1,2));
	}

    /*a + b < c */
    @Test
	public void F_EqualityIsNotTriangle_2() {
		assertFalse(Demo.isTriangle(1,1,3));
	}

    /*a + c = b */
    @Test
	public void F_EqualityIsNotTriangle_3() {
		assertFalse(Demo.isTriangle(1,2,1));
	}

    /*a + c < b */
    @Test
	public void F_EqualityIsNotTriangle_4() {
		assertFalse(Demo.isTriangle(1,3,1));
	}

    /*b + c = a */
    @Test
	public void F_EqualityIsNotTriangle_5() {
		assertFalse(Demo.isTriangle(2,1,1));
	}
    /*b + c < a */
    @Test
	public void F_EqualityIsNotTriangle_6() {
		assertFalse(Demo.isTriangle(3,1,1));
	}

/*mutant versions - sign changes*/
    /*a - b > c */
    @Test
	public void F_SignIsNotTriangle_1() {
		assertFalse(Demo.isTriangle(5,1,3));
	}

    /*a - c > b */
    @Test
	public void F_SignIsNotTriangle_2() {
		assertFalse(Demo.isTriangle(5,3,1));
	}

    /*b - c > a */
    @Test
	public void F_SignIsNotTriangle_3() {
		assertFalse(Demo.isTriangle(3,5,1));
	}

/*mutant versions - variable changes*/
    /*{!a} + b > c */
    @Test
	public void F_VariableIsNotTriangle_1() {
		assertFalse(Demo.isTriangle(1,4,5));
	}
    
    /*a + {!b} > c */
    @Test
	public void F_VariableIsNotTriangle_2() {
		assertFalse(Demo.isTriangle(3,2,5));
	}
    
    /*a + b > {!c} */
    @Test
	public void F_VariableIsNotTriangle_3() {
		assertFalse(Demo.isTriangle(3,4,7));
	}

/*special cases - zeros and negatives*/
    /*a = 0*/
    @Test
    public void F_ZeroEdge_1() {
        assertFalse(Demo.isTriangle(0,4,5));
    }

    /*b = 0*/
    @Test
    public void F_ZeroEdge_2() {
        assertFalse(Demo.isTriangle(0,4,5));
    }

    /*c = 0*/
    @Test
    public void F_ZeroEdge_3() {
        assertFalse(Demo.isTriangle(3,4,0));
    }

    /*a && b = 0*/
    @Test
    public void F_ZeroEdge_4() {
        assertFalse(Demo.isTriangle(0,0,5));
    }

    /*a && c = 0*/
    @Test
    public void F_ZeroEdge_5() {
        assertFalse(Demo.isTriangle(0,4,0));
    }

    /*b && c = 0*/
    @Test
    public void F_ZeroEdge_6() {
        assertFalse(Demo.isTriangle(3,0,0));
    }

    /*a && b && c = 0*/
    @Test
    public void F_ZeroEdge_7() {
        assertFalse(Demo.isTriangle(0,0,0));
    }

    /*a && b && c = -0*/
    @Test
    public void F_ZeroEdge_8() {
        assertFalse(Demo.isTriangle(-0,-0,-0));
    }

/*non-integers */
    @Test
    public void F_nonInteger() {
        assertFalse(Demo.isTriangle(-6.8, 8.2, 10.1));
    }

/*negatives */
    /*a < 0*/
    @Test
    public void F_NegativeInput_1() {
        assertFalse(Demo.isTriangle(-3,4,5));
    }

    /*b < 0*/
    @Test
    public void F_NegativeInput_2() {
        assertFalse(Demo.isTriangle(3,-4,5));
    }
    
    /*c < 0*/
    @Test
    public void F_NegativeInput_3() {
        assertFalse(Demo.isTriangle(3,4,-5));
    }

    /*a && b < 0*/
    @Test
    public void F_NegativeInput_4() {
        assertFalse(Demo.isTriangle(-3,-4,5));
    }

    /*a && c < 0*/
    @Test
    public void F_NegativeInput_5() {
        assertFalse(Demo.isTriangle(-3,4,-5));
    }

    /*b && c < 0*/
    @Test
    public void F_NegativeInput_6() {
        assertFalse(Demo.isTriangle(3,-4,-5));
    }

    /*a && b && c < 0*/
    @Test
    public void F_NegativeInput_7() {
        assertFalse(Demo.isTriangle(-3,-4,-5));
    }
/***************I/O**************/

	@Test
	public void positive_testInput ()  {		
		//to get user input in JUnit, need to redirect the system in and system out
		ByteArrayInputStream in = new ByteArrayInputStream("3\n4\n5\n".getBytes());  
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		//invoke main with empty string cuz we're not actually passing anything
		String[] args = {};
		Demo.main(args);

		//expected output
		String consoleOutput = "Enter side 1: \n";       
		consoleOutput += "Enter side 2: \n" ;       
		consoleOutput += "Enter side 3: \n" ;       
		consoleOutput +=  "This is a triangle.";       
		
        //replaceAll /r/n (Windows line endings) with /n (Unix-style line endings) to account for differences between command line interfaces
        //trim to get rid of trailing whitespace
        String actualOutput = out.toString().trim().replaceAll("\\r\\n", "\n");

        System.out.println("Actual Output:\n" + actualOutput);
        
        // Compare the actual and expected output
        assertEquals(consoleOutput, actualOutput);  
	}

    @Test
    public void negative_testInput ()  {		
		//to get user input in JUnit, need to redirect the system in and system out
		ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n3\n".getBytes());  
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		//invoke main with empty string cuz we're not actually passing anything
		String[] args = {};
        //String[] args={}; 
		Demo.main(args);

		//expected output
		String consoleOutput = "Enter side 1: \n";       
		consoleOutput += "Enter side 2: \n" ;       
		consoleOutput += "Enter side 3: \n" ;       
		consoleOutput +=  "This is not a triangle.";       
		
        //replaceAll \r\n with \n to account for line ending differences between Unix and Windows
        String actualOutput = out.toString().trim().replaceAll("\\r\\n", "\n");

        System.out.println("Actual Output:\n" + actualOutput);
        
        // Compare the actual and expected output
        assertEquals(consoleOutput, actualOutput);  
	}
}