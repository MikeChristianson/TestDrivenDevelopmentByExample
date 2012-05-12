package net.christiansons.mike;

import java.util.Hashtable;

public class Bank {
	
	private Hashtable<Pair<Currency,Currency>, Integer> rates = new Hashtable<>();

	public Money reduce(Expression source, Currency toCurrency) {
		return source.reduce(this, toCurrency);
	}

	public void addRate(Currency from, Currency to, int rate) {
		Pair<Currency, Currency> key = new Pair<>(from, to);
		rates.put(key, rate);
	}

	public int rate(Currency from, Currency to) {
		if(from.equals(to)) {
			return 1;
		}
		Pair<Currency, Currency> key = new Pair<>(from, to);
		return rates.get(key);
	}

}
