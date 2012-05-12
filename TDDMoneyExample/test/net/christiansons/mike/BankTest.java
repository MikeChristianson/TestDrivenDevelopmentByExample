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
	
	@Test
	public void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}
	
	@Test
	public void testIdentityRate() {
		int identityRate = new Bank().rate("USD", "USD");
		assertEquals(1, identityRate);
	}
	
	@Test
	public void testMixedAddition() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		Expression fiveBucksPlusTenFrancs = fiveBucks.plus(tenFrancs);
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucksPlusTenFrancs, "USD");
		assertEquals(Money.dollar(10), result);
	}

}
