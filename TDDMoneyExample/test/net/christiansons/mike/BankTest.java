package net.christiansons.mike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testReduceMoney() {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1), result);
	}

	@Test
	public void testReduceSum() {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(7), result);
	}

}
