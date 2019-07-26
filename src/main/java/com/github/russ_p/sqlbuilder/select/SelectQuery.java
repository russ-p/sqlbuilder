package com.github.russ_p.sqlbuilder.select;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

class SelectQuery {

	private final Deque<String> columns = new ArrayDeque<>();

	private final List<String> tables = new ArrayList<>();

	private final List<String> whereParts = new ArrayList<>();

	private final Deque<String> orderBy = new ArrayDeque<>();

	private final List<String> groupBy = new ArrayList<>();

	private final List<String> join = new ArrayList<>();

	public void addColumn(String columnName) {
		columns.add(columnName);
	}

	public void addColumn(String columnName, String alias) {
		columns.add(columnName + " AS " + alias);
	}

	public void addColumnAlias(String alias) {
		String col = columns.pollLast();
		if (col != null) {
			addColumn(col, alias);
		}
	}

	public void addTable(String tableName) {
		tables.add(tableName);
	}

	public void addCondition(String condition) {
		whereParts.add(condition);
	}

	public void addAndCondition(String condition) {
		whereParts.add(" AND\n  " + condition);
	}

	public void addOrder(String columnName) {
		orderBy.add(columnName);
	}

	public void setOrderDesc() {
		String col = orderBy.pollLast();
		orderBy.add(col + " DESC");
	}

	public void addGroup(String columnName) {
		groupBy.add(columnName);
	}

	public void addJoin(String joinStr) {
		join.add(joinStr);
	}

	public void addJoinCondition(String condition) {
		int lastIndex = join.size() - 1;
		String s = join.get(lastIndex) + " ON " + condition;
		join.set(lastIndex, s);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("SELECT\n  ");
		sb.append(columns.stream().collect(Collectors.joining(",\n  ")));

		sb.append("\nFROM\n  ");
		sb.append(tables.stream().collect(Collectors.joining(", ")));

		if (!join.isEmpty()) {
			sb.append("\n");
			sb.append(join.stream().collect(Collectors.joining("\n  ")));
		}

		sb.append("\nWHERE\n  ");
		sb.append(whereParts.stream().collect(Collectors.joining("\n  ")));

		if (!groupBy.isEmpty()) {
			sb.append("\nGROUP BY\n  ");
			sb.append(groupBy.stream().collect(Collectors.joining(", ")));
		}

		if (!orderBy.isEmpty()) {
			sb.append("\nORDER BY ");
			sb.append(orderBy.stream().collect(Collectors.joining(", ")));
		}

		return sb.toString();
	}

}
