package player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlayerConn {
	public static Connection getConn2019() throws ClassNotFoundException, SQLException{
		//2019년도 db 접속용
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String user = "root";
		String password = "mysql";
		String url =  "jdbc:mysql://localhost:3306/ktwiz2019?characterEncoding=utf-8&&serverTimezone=Asia/Seoul";
		
		return DriverManager.getConnection(url, user,password);
	}
	
	public static Connection getConn2020() throws ClassNotFoundException, SQLException{
		//2020년도 db 접속용
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String user = "root";
		String password = "mysql";
		String url =  "jdbc:mysql://localhost:3306/ktwiz2020?characterEncoding=utf-8&&serverTimezone=Asia/Seoul";
		
		return DriverManager.getConnection(url, user,password);
	}
	public static Connection getConn2021() throws ClassNotFoundException, SQLException{
		//2021년도 db 접속용
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String user = "root";
		String password = "mysql";
		String url =  "jdbc:mysql://localhost:3306/ktwiz2021?characterEncoding=utf-8&&serverTimezone=Asia/Seoul";
		
		return DriverManager.getConnection(url, user,password);
	}

}
