package net.christiansons.mike;

public class Money implements Expression {

	protected int amount;
	protected String currency;

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

	public Money times(int multiplier) {
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

	public Money plus(Money addend) {
		int sum = this.amount + addend.amount;
		return new Money(sum, this.currency);
	}
	
	
}