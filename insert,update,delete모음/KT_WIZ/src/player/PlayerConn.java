package player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlayerConn {
	public static Connection getConn2021() throws ClassNotFoundException, SQLException{
		//2021년도 db 접속용
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	    String id = "root";
		String password = "mysql";
		String url = "jdbc:mysql://localhost:3306/ktwiz2021?charactorEncoding"
				+ "=utf-8&serverTimezone=Asia/Seoul";
		
		//접속
		return DriverManager.getConnection(url, id, password);
	}
}	
