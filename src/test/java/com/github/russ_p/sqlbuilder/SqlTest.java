package com.github.russ_p.sqlbuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SqlTest {

	private static Connection conn;

	@Before
	public void setUp() throws Exception {
	}

	@BeforeClass
	public static void start() throws SQLException {
		conn = DriverManager.getConnection("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1", "sa", "");

		conn.createStatement().execute("CREATE TABLE `test_table` (\n" +
				"  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
				"  `code` varchar(255) DEFAULT NULL\n" +
				")");

		conn.createStatement().execute("CREATE TABLE `another_table` (\n" +
				"  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
				"  `test_id` bigint(20),\n" +
				"  `code` varchar(255) DEFAULT NULL\n" +
				")");
	}

	@AfterClass
	public static void finish() throws SQLException {
		conn.close();
	}

	@Test
	public void testSelect() throws Exception {
		String sql = Sql.select()
				.column("id").as("col_id")
				.column("code").as("col_code")
				.from("test_table")
				.where("id = 1")
				.groupBy("id")
				.orderBy("id").by("code").desc()
				.toString();

		conn.createStatement().execute(sql);

		System.out.println(sql);
	}

	@Test
	public void testSelectWithJoin() throws Exception {
		String sql = Sql.select()
				.column("t1.id").as("col_id")
				.column("t1.code").as("col_code")
				.from("test_table t1")
				.join("another_table t2").on("t2.test_id = t1.id")
				.where("t1.id = 1").and("t2.id = 1")
				.groupBy("t1.id")
				.orderBy("t1.id").by("t1.code").desc()
				.toString();

		conn.createStatement().execute(sql);

		System.out.println(sql);
	}

}
