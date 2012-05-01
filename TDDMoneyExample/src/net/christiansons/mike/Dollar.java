package net.christiansons.mike;

public class Dollar {

	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int multiplier) {
		return new Dollar(amount * multiplier);
	}
	
	@Override
	public boolean equals(Object other) {
		return amount == ((Dollar)other).amount;
	}

}
