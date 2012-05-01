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
		assertEquals(10, five.amount);
	}

}
