package net.christiansons.mike;

public abstract class Money {

	protected int amount;

	public static Money dollar(int amount) {
		return new Dollar(amount);
	}

	public static Franc franc(int amount) {
		return new Franc(amount);
	}

	public abstract Money times(int amount);
	
	@Override
	public boolean equals(Object other) {
		boolean sameAmount = amount == ((Money)other).amount;
		boolean sameClass = this.getClass().equals(other.getClass());
		return sameAmount && sameClass;
	}

}