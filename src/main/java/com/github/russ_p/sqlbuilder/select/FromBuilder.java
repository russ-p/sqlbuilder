package com.github.russ_p.sqlbuilder.select;

public class FromBuilder extends AbstractQueryBuilder<SelectQuery> {

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

	public JoinBuilder join(String table) {
		return innerJoin(table);
	}

	public JoinBuilder innerJoin(String table) {
		return new JoinBuilder(query, "inner", table);
	}

	public JoinBuilder leftJoin(String table) {
		return new JoinBuilder(query, "left", table);
	}

	public JoinBuilder rightJoin(String table) {
		return new JoinBuilder(query, "right", table);
	}

	public JoinBuilder crossJoin(String table) {
		return new JoinBuilder(query, "cross", table);
	}
}
