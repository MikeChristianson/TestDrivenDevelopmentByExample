package net.christiansons.mike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FrancTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMultiplication() {
		Franc five = new Franc(5);
		five.times(2);
		Franc fifteen = five.times(3);
		assertEquals(new Franc(15), fifteen);
	}
	
	@Test
	public void testEquality() {
		assertEquals(new Franc(5), new Franc(5));
		assertNotSame(new Franc(5), new Franc(6));
	}

}
