package com.github.russ_p.sqlbuilder.select;

public class JoinConditionBuilder extends AbstractQueryBuilder<SelectQuery> implements JoinMixin {

	public JoinConditionBuilder(SelectQuery query, String condition) {
		super(query);
		query.addJoinCondition(condition);
	}

	public WhereBuilder where(String condition) {
		return new WhereBuilder(query, condition);
	}

	@Override
	public SelectQuery getQuery() {
		return query;
	}

}
