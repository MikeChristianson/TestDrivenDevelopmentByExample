package net.christiansons.mike;

public class Sum implements Expression {
	public Expression augend;
	public Expression addend;

	public Sum(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	@Override
	public	Money reduce(Bank bank, String toCurrency) {
		int reducedAugend = augend.reduce(bank, toCurrency).amount;
		int reducedAddend = addend.reduce(bank, toCurrency).amount;
		int amount = reducedAugend + reducedAddend;
		return new Money(amount, toCurrency);
	}

	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	@Override
	public Expression times(int multiplier) {
		Expression multipliedAugend = augend.times(multiplier);
		Expression multipliedAddend = addend.times(multiplier);
		return new Sum(multipliedAugend, multipliedAddend);
	}

}
