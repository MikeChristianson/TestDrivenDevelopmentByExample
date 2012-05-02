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
		Money five = Money.dollar(5);
		five.times(2);
		Money fifteen = five.times(3);
		assertEquals(Money.dollar(15), fifteen);
	}
	
	@Test
	public void testEquality() {
		assertEquals(Money.dollar(5), Money.dollar(5));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
	}

}
