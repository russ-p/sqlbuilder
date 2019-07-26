package com.github.russ_p.sqlbuilder.select;

public class JoinConditionBuilder extends AbstractQueryBuilder<SelectQuery> {

	public JoinConditionBuilder(SelectQuery query, String condition) {
		super(query);
		query.addJoinCondition(condition);
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
