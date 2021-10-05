package network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlayerConn {
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		//이클립스 db 연결용.......
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String user = "root";
		String password = "mysql";
		String url =  "jdbc:mysql://localhost:3306/kt_wiz?characterEncoding=utf-8&&serverTimezone=Asia/Seoul";
		
		return DriverManager.getConnection(url, user,password);
	}
}
	
