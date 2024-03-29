package net.christiansons.mike;

abstract public class Expression {

	abstract public Money reduce(Bank bank, Currency to);

	abstract public Expression times(int multiplier);

	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}

}
