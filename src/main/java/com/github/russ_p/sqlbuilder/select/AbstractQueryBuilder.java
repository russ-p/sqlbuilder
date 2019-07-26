package com.github.russ_p.sqlbuilder.select;

abstract class AbstractQueryBuilder<T> {

	protected final T query;

	public AbstractQueryBuilder(T query) {
		this.query = query;
	}

	@Override
	public String toString() {
		return query.toString();
	}

}
