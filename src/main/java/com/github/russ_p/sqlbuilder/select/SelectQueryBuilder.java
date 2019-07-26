package com.github.russ_p.sqlbuilder.select;

public class SelectQueryBuilder extends AbstractQueryBuilder<SelectQuery> {

	public SelectQueryBuilder() {
		super(new SelectQuery());
	}

	public SelectQueryBuilder column(String columnName) {
		query.addColumn(columnName);
		return this;
	}

	public SelectQueryBuilder as(String alias) {
		query.addColumnAlias(alias);
		return this;
	}

	public FromBuilder from(String table) {
		return new FromBuilder(query, table);
	}

	@Override
	public String toString() {
		return query.toString();
	}
}
