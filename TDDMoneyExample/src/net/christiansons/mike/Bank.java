package net.christiansons.mike;

import java.util.Hashtable;

public class Bank {
	
	private Hashtable<Pair<String,String>, Integer> rates = new Hashtable<>();

	public Money reduce(Expression source, String toCurrency) {
		return source.reduce(this, toCurrency);
	}

	public void addRate(String from, String to, int rate) {
		Pair<String,String> key = new Pair<>(from, to);
		rates.put(key, rate);
	}

	public int rate(String currency, String toCurrency) {
		if(currency.equals(toCurrency)) {
			return 1;
		}
		Pair<String,String> key = new Pair<>(currency, toCurrency);
		return rates.get(key);
	}

}
