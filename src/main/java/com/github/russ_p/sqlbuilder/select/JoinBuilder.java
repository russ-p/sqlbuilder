package com.github.russ_p.sqlbuilder.select;

public class JoinBuilder extends AbstractQueryBuilder<SelectQuery> {

	public JoinBuilder(SelectQuery query, String joinType, String table) {
		super(query);
		query.addJoin("\n " + joinType.toUpperCase() + " JOIN " + table);
	}

	public JoinConditionBuilder on(String condition) {
		return new JoinConditionBuilder(query, condition);
	}

}
