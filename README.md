# sqlbuilder
simple sql builder

From
````java
String sql = Sql.select()
    .column("id").as("col_id")
    .column("code").as("col_code")
    .from("test_table")
    .where("id = 1")
    .groupBy("id")
    .orderBy("id").by("code").desc()
    .toString();
````
to
````
SELECT
  id AS col_id,
  code AS col_code
FROM
  test_table
WHERE
  id = 1
GROUP BY
  id
ORDER BY id, code DESC
````
