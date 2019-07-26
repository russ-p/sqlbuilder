package com.github.russ_p.sqlbuilder.select;

public class JoinBuilder extends AbstractQueryBuilder<SelectQuery> {

	JoinBuilder(SelectQuery query, JoinType joinType, String table) {
		super(query);
		join(joinType, table);
	}

	public JoinConditionBuilder on(String condition) {
		return new JoinConditionBuilder(query, condition);
	}

	public JoinBuilder join(String table) {
		return innerJoin(table);
	}

	public JoinBuilder innerJoin(String table) {
		return join(JoinType.INNER, table);
	}

	public JoinBuilder leftJoin(String table) {
		return join(JoinType.LEFT, table);
	}

	public JoinBuilder rightJoin(String table) {
		return join(JoinType.RIGHT, table);
	}

	public JoinBuilder crossJoin(String table) {
		return join(JoinType.CROSS, table);
	}

	public WhereBuilder where(String condition) {
		return new WhereBuilder(query, condition);
	}

	private JoinBuilder join(JoinType joinType, String table) {
		query.addJoin(" " + joinType.toString() + " JOIN " + table);
		return this;
	}
}
