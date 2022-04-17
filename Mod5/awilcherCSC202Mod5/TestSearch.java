/**
 * 
 */
package awilcherCSC202Mod5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Aubrey
 *
 */
class TestSearch {

	int[] a;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		a = new int[] {1,2,3,4,6};
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link testing.SearchTesting#search(int[], int)}.
	 */
	
	/**
	@Test
	void testSearch() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	void testSearchNoItem() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What value do you want to test?");
		int key = scan.nextInt();
		boolean val = (new SearchTesting()).search(a, key);
		assertTrue(val);
				
	}

}
