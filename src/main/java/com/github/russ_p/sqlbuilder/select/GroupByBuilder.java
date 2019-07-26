package com.github.russ_p.sqlbuilder.select;

public class GroupByBuilder extends AbstractQueryBuilder<SelectQuery> {

	GroupByBuilder(SelectQuery query, String[] columns) {
		super(query);
		for (String column : columns) {
			query.addGroup(column);
		}
	}

	public OrderByBuilder orderBy(String... columns) {
		return new OrderByBuilder(query, columns);
	}

}
