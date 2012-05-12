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
	public Expression plus(Expression tenFrancs) {
		// TODO Auto-generated method stub
		return null;
	}

}
