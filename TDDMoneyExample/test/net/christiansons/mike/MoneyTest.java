package net.christiansons.mike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEquality() {
		Money fiveFrancs = Money.franc(5);
		Money fiveDollars = Money.dollar(5);
		assertFalse(fiveFrancs.equals(fiveDollars));
	}
	
	@Test
	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}

}
