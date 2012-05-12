package net.christiansons.mike;

public class Money implements Expression {

	protected int amount;
	private String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
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

	public String currency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + ", getClass()=" + getClass() + "]";
	}

	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
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

	public Money reduce(Bank bank, String toCurrency) {
		int rate = bank.rate(currency, toCurrency);
		return new Money(amount / rate, toCurrency);
	}
	
	
}