/**
 * 
 */
package awilcherCSC202Mod5;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Aubrey
 *
 */
class ArrayIntTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddAndGet1() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(35);
		list.add(-25);
		list.add(50);
		list.add(6);
		assertEquals(35, list.get(0));
		assertEquals(-25, list.get(1));
		assertEquals(50, list.get(2));
		assertEquals(6, list.get(3));

		assertEquals("second attempt", 35, (int) list.get(0)); // make sure I can get them a second time
		assertEquals("second attempt", 6, (int) list.get(3));

	}

	@Test
	public void testSize1() {
		ArrayList<Integer> list = new ArrayList<>();
		assertEquals(0, list.size());
		list.add(84);
		list.add(55);
		assertEquals(2, list.size());
		list.add(-13);
		list.add(1000);
		assertEquals(4, list.size());
		list.add(23);
		assertEquals(5, list.size());
		list.add(79);
		assertEquals(6, list.size());
		assertEquals("second attempt", 6, list.size()); // make sure I can get it a second time
	}

}
