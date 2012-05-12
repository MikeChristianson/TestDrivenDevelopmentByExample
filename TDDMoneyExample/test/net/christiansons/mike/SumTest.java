package net.christiansons.mike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SumTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReduce() {
		Money dollar = Money.dollar(1);
		Sum sum = new Sum(dollar, dollar);
		Money reduce = sum.reduce(new Bank(), dollar.currency());
		assertEquals(Money.dollar(2), reduce);
	}

}
