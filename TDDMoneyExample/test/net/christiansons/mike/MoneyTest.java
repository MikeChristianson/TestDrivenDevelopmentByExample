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
		Franc fiveFrancs = new Franc(5);
		Dollar fiveDollars = new Dollar(5);
		assertFalse(fiveFrancs.equals(fiveDollars));
	}

}
