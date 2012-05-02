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
		Franc five = Money.franc(5);
		five.times(2);
		Money fifteen = five.times(3);
		assertEquals(Money.franc(15), fifteen);
	}
	
	@Test
	public void testEquality() {
		assertEquals(Money.franc(5), Money.franc(5));
		assertFalse(Money.franc(5).equals(Money.franc(6)));
	}

}
