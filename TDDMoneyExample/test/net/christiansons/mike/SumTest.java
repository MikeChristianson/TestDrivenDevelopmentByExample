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
	
	@Test
	public void testSumPlusMoney() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs);
		sum = sum.plus(fiveBucks);
		Money result = bank.reduce(sum, "USD");
//		Money result = sum.reduce(bank, "USD");
		assertEquals(Money.dollar(15), result);
	}
	
	@Test
	public void testSumTimes() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks, tenFrancs);
		sum = sum.times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
	}

}
