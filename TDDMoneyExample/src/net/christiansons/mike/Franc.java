package net.christiansons.mike;

public class Franc {

	private int amount;

	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc times(int multiplier) {
		return new Franc(amount * multiplier);
	}
	
	@Override
	public boolean equals(Object other) {
		return amount == ((Franc)other).amount;
	}

}
