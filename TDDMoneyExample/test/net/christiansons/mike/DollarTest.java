package net.christiansons.mike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DollarTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		five.times(2);
		Dollar fifteen = five.times(3);
		assertEquals(new Dollar(15), fifteen);
	}
	
	@Test
	public void testEquality() {
		assertEquals(new Dollar(5), new Dollar(5));
		assertNotSame(new Dollar(5), new Dollar(6));
	}

}
