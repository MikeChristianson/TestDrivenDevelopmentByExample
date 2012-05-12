package net.christiansons.mike;

public class Pair<K,V> {
	private final K from;
	private final V to;

	Pair(K from, V to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Pair<?,?> other = (Pair<?,?>) obj;
		return from.equals(other.from) && to.equals(other.to);
	}
	
	
}
