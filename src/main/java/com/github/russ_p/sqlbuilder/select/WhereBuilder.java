package com.github.russ_p.sqlbuilder.select;

public class WhereBuilder extends AbstractQueryBuilder<SelectQuery> {

	WhereBuilder(SelectQuery query) {
		super(query);
	}

	WhereBuilder(SelectQuery query, String condition) {
		this(query);
		query.addCondition(condition);
	}

	public WhereBuilder and(String condition) {
		query.addAndCondition(condition);
		return this;
	}

	public OrderByBuilder orderBy(String... columns) {
		return new OrderByBuilder(query, columns);
	}

	public GroupByBuilder groupBy(String... columns) {
		return new GroupByBuilder(query, columns);
	}

}
