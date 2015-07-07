import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

import org.jooq.impl.DSL;

/*
 * ============================================================
 * The SSE USTC Software License
 * 
 * TestDb.java
 * 2015年7月6日
 * 
 * Copyright (c) 2006 China Payment and Remittance Service Co.,Ltd        
 * All rights reserved.
 * ============================================================
 */

/**
 * 实现功能： 
 * <p>
 * date	    author            email		           notes<br />
 * --------	---------------------------	---------------<br />
 *2015年7月6日	 邱星            starqiu@mail.ustc.edu.cn	      新建类<br /></p>
 *
 */
public class TestDb {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class clz = Class.forName("com.mysql.jdbc.Driver");
		System.out.println(clz);
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testDb","root", "xing123");
		String sql = "select * from users limit 10 ";
//		jdbcMethod(conn);
		

		jooqMethod(conn, sql);
		
//		DSL.using(conn)
//				.select()
//				.
			
	}


	/**
	 * @param conn
	 * @param sql
	 */
	private static void jooqMethod(Connection conn, String sql) {
	//		DSL.using(conn)
		//		.fetch(sql)
		//		.stream()
		//		.forEach(System.out::println);
			
		DSL.using(conn)
				.fetch(sql)
				.stream()
				.collect(Collectors.groupingBy(r->r.getValue("id"),
						Collectors.mapping(r->r.getValue("name"), 
								Collectors.toList()))
						)
				.forEach((key,value) -> System.out.println(key+" : "+value));
	}


	private static void jdbcMethod(Connection conn,String sql) throws SQLException {
		Statement statement = conn.createStatement();

		ResultSet rs = statement.executeQuery(sql);
	
		while (rs.next()) {
			String name = rs.getString("name");
			System.out.println(rs.getString("id") + "\t" + name);
		}
	}
}

