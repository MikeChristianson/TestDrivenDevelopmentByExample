package net.christiansons.mike;

public class Money {

	protected int amount;

	@Override
	public boolean equals(Object other) {
		return amount == ((Money)other).amount;
	}

}