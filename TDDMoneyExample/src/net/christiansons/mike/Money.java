package net.christiansons.mike;

public abstract class Money {

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public static Money dollar(int amount) {
		return new Dollar(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Franc(amount, "CHF");
	}

	public abstract Money times(int amount);
	
	@Override
	public boolean equals(Object other) {
		boolean sameAmount = amount == ((Money)other).amount;
		boolean sameClass = this.getClass().equals(other.getClass());
		return sameAmount && sameClass;
	}

	public String currency() {
		return currency;
	}

}