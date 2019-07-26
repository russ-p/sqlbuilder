package com.github.russ_p.sqlbuilder.select;

interface JoinMixin {

	default JoinBuilder join(String table) {
		return innerJoin(table);
	}

	default JoinBuilder innerJoin(String table) {
		return new JoinBuilder(getQuery(), JoinType.INNER, table);
	}

	default JoinBuilder leftJoin(String table) {
		return new JoinBuilder(getQuery(), JoinType.LEFT, table);
	}

	default JoinBuilder rightJoin(String table) {
		return new JoinBuilder(getQuery(), JoinType.RIGHT, table);
	}

	default JoinBuilder crossJoin(String table) {
		return new JoinBuilder(getQuery(), JoinType.CROSS, table);
	}

	SelectQuery getQuery();
}
