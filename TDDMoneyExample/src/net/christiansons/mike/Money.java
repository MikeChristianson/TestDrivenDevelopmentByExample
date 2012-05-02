package net.christiansons.mike;

public class Money {

	protected int amount;

	@Override
	public boolean equals(Object other) {
		boolean sameAmount = amount == ((Money)other).amount;
		boolean sameClass = this.getClass().equals(other.getClass());
		return sameAmount && sameClass;
	}

}