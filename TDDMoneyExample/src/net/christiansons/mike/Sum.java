package net.christiansons.mike;

public class Sum extends Expression {
	public Expression augend;
	public Expression addend;

	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	@Override
	public Money reduce(Bank bank, Currency to) {
		int reducedAugend = augend.reduce(bank, to).amount;
		int reducedAddend = addend.reduce(bank, to).amount;
		int amount = reducedAugend + reducedAddend;
		return new Money(amount, to);
	}

	@Override
	public Expression times(int multiplier) {
		Expression multipliedAugend = augend.times(multiplier);
		Expression multipliedAddend = addend.times(multiplier);
		return new Sum(multipliedAugend, multipliedAddend);
	}

}
