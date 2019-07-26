package com.github.russ_p.sqlbuilder.select;

public class OrderByBuilder extends AbstractQueryBuilder<SelectQuery> {

	OrderByBuilder(SelectQuery query) {
		super(query);
	}

	public OrderByBuilder(SelectQuery query, String... columns) {
		super(query);
		for (String column : columns) {
			query.addOrder(column);
		}
	}

	public OrderByBuilder by(String column) {
		query.addOrder(column);
		return this;
	}

	public OrderByBuilder desc() {
		query.setOrderDesc();
		return this;
	}

}
