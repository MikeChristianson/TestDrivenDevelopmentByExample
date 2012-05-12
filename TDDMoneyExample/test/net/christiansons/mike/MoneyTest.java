package net.christiansons.mike;

import static org.junit.Assert.*;
import static net.christiansons.mike.Currency.*;

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
		assertEquals(USD, Money.dollar(1).currency());
		assertEquals(CHF, Money.franc(1).currency());
	}
	
	@Test
	public void testSimpleAddition() {
		Expression five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, USD);
		assertEquals(Money.dollar(10), reduced);
	}

	@Test
	public void testPlusReturnsSum() {
		Expression five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum)result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}
	
	@Test
	public void testReduce() {
		Money dollar = Money.dollar(1);
		Money reduce = dollar.reduce(new Bank(), dollar.currency());
		assertEquals(dollar, reduce);
	}
	
	@Test
	public void testPlusSameCurrencyReturnsMoney() {
		Money result = Money.dollar(1).plus(Money.dollar(1));
		assertEquals(Money.dollar(2), result);
	}

}
