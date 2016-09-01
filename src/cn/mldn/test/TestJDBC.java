package cn.mldn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", "root", "root");
		PreparedStatement stmt = conn
				.prepareStatement("select username,create_date,content"
						+ " from member as m left join detail as d "
						+ " on m.nid=d.nid where m.nid=?");
		stmt.setInt(1, 1);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("username") + "-"
					+ rs.getString("create_date") + "-"
					+ rs.getString("content"));
		}

		rs.close();
		stmt.close();
		conn.close();
	}
}
