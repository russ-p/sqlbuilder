package com.github.russ_p.sqlbuilder;

import com.github.russ_p.sqlbuilder.select.SelectQueryBuilder;

public class Sql {

	public static SelectQueryBuilder select() {
		return new SelectQueryBuilder();
	}

}
