package com.github.russ_p.sqlbuilder.select;

public class FromBuilder extends AbstractQueryBuilder<SelectQuery> implements JoinMixin {

	FromBuilder(SelectQuery query, String table) {
		super(query);
		query.addTable(table);
	}

	public WhereBuilder where() {
		return new WhereBuilder(query);
	}

	public WhereBuilder where(String condition) {
		return new WhereBuilder(query, condition);
	}

	@Override
	public SelectQuery getQuery() {
		return query;
	}

}
