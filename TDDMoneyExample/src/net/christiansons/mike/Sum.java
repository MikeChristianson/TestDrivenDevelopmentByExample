package net.christiansons.mike;

public class Sum implements Expression {
	public Money augend;
	public Money addend;

	public Sum(Money augend, Money addend) {
		this.augend = augend;
		this.addend = addend;
	}

	@Override
	public	Money reduce(Bank bank, String toCurrency) {
		int amount = augend.amount + addend.amount;
		return new Money(amount, toCurrency);
	}

}
