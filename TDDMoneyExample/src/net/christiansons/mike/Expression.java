package net.christiansons.mike;

public interface Expression {

	public Money reduce(Bank bank, String toCurrency);

	public Expression plus(Expression tenFrancs);

}
