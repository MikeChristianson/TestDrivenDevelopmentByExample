package net.christiansons.mike;

public class Money extends Expression {

	protected int amount;
	private Currency currency;

	public Money(int amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Money dollar(int amount) {
		return new Money(amount, Currency.USD);
	}

	public static Money franc(int amount) {
		return new Money(amount, Currency.CHF);
	}

	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}	

	@Override
	public boolean equals(Object other) {
		Money otherMoney = (Money)other;
		boolean sameAmount = amount == otherMoney.amount;
		boolean sameCurrency = currency.equals(otherMoney.currency());
		return sameAmount && sameCurrency;
	}

	public Currency currency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + ", getClass()=" + getClass() + "]";
	}

	/**
	 * An attempt at solving the idea of returning Money
	 * from $5 + $5 rather than Sum.
	 */
	public Money plus(Money addend) {
		if(currency.equals(addend.currency())) {
			int sum = amount + addend.amount;
			return new Money(sum, currency);
		}
		return plus(addend);
	}

	public Money reduce(Bank bank, Currency to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
	
	
}