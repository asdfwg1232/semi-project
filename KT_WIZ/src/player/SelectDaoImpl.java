package player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SelectDaoImpl implements SelectDao{
	
	private static SelectDaoImpl instance = new SelectDaoImpl();
	private SelectDaoImpl() {}
	public static SelectDaoImpl getInstance() {return instance;}

	@Override//투수 컬럼으로 조회
	//name, salary, deposit, position, number, era, phr, win, lose, sv
	public List<Pitcherplayer> pitcherOrderBy(String columnName, String orderBy) throws ClassNotFoundException, SQLException {
		String sql ="select * from Pitcher order by "+columnName+" "+orderBy;
		try(Connection conn = PlayerConn.getConn2021();
				Statement stmt =conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			List<Pitcherplayer> pitcherList = new ArrayList<Pitcherplayer>();
			
			while(rs.next()) {
				pitcherList.add(new Pitcherplayer(rs.getString("name"), rs.getInt("salary"),
						rs.getInt("deposit"),rs.getString("position"), rs.getInt("number"),
						rs.getDouble("era"), rs.getInt("phr"), rs.getInt("win"), rs.getInt("lose"), rs.getInt("sv")));
			}
			return pitcherList;
		}
		
	}

	@Override//타자 컬럼으로 조회
	//name, salary, deposit, position, number,avg, hr,sb
	public List<Batterplayer> batterOrderBy(String columnName, String orderBy) throws ClassNotFoundException, SQLException {
		String sql ="select * from Batter order by "+columnName+" "+orderBy;
		try(Connection conn = PlayerConn.getConn2021();
				Statement stmt =conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			List<Batterplayer> batterList= new ArrayList<Batterplayer>();
			
			while(rs.next()) {
				batterList.add(new Batterplayer(rs.getString("name"), rs.getInt("salary"), 
						rs.getInt("deposit"), rs.getString("position"),rs.getInt("number"),
						rs.getDouble("avg"), rs.getInt("hr"),rs.getInt("sb")));
			}
			return batterList;
		}
	}
	
	@Override//투수 개인 조회
	public List<Pitcherplayer> pitcherFindLimit(String columnName, String orderBy, int num) throws ClassNotFoundException, SQLException{
		String sql ="select * from Pitcher "+columnName+" order by "+columnName+" "+orderBy+" limit "+num;
		try(Connection conn = PlayerConn.getConn2021();
				Statement stmt =conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			
			List<Pitcherplayer> pitcherList = new ArrayList<Pitcherplayer>();
			
			while(rs.next()) {
				pitcherList.add(new Pitcherplayer(rs.getString("name"), rs.getInt("salary"),
						rs.getInt("deposit"),rs.getString("position"), rs.getInt("number"),
						rs.getDouble("era"), rs.getInt("phr"), rs.getInt("win"), rs.getInt("lose"), rs.getInt("sv")));
			}
			return pitcherList;
		}
		
	}
	
	@Override//타자 개인 조회
	public List<Batterplayer> batterFindLimit(String columnName, String orderBy, int num) throws ClassNotFoundException, SQLException {
		String sql ="select * from Batter "+columnName+" order by "+columnName+" "+orderBy+" limit "+num;
		try(Connection conn = PlayerConn.getConn2021();
				Statement stmt =conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			List<Batterplayer> batterList= new ArrayList<Batterplayer>();
			
			while(rs.next()) {
				batterList.add(new Batterplayer(rs.getString("name"), rs.getInt("salary"), 
						rs.getInt("deposit"), rs.getString("position"),rs.getInt("number"),
						rs.getDouble("avg"), rs.getInt("hr"),rs.getInt("sb")));
			}
			return batterList;
		}
	}
	@Override//투수 연봉 top 5명 조회
	public List<Pitcherplayer> pSalaryLimit(String orderBy) throws ClassNotFoundException, SQLException {
		String sql = "select * from Pitcherplayer order by salary "+orderBy+ " limit 5";
		try(Connection conn = PlayerConn.getConn2021();
				Statement stmt =conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			List<Pitcherplayer> pitcherList= new ArrayList<Pitcherplayer>();
			
			while(rs.next()) {
				pitcherList.add(new Pitcherplayer(rs.getString("name"), rs.getInt("salary"),
						rs.getInt("deposit"),rs.getString("position"), rs.getInt("number"),
						rs.getDouble("era"), rs.getInt("phr"), rs.getInt("win"), rs.getInt("lose"), rs.getInt("sv")));
			}
		return pitcherList;
		}
	}
	@Override//타자 연봉 top 10명 조회
	public List<Batterplayer> bSalaryLimit(String orderBy) throws ClassNotFoundException, SQLException {
		String sql = "select * from Batterplayer order by salary "+orderBy+" limit 10";
		try(Connection conn = PlayerConn.getConn2021();
				Statement stmt =conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
			List<Batterplayer> batterList= new ArrayList<Batterplayer>();
			
			while(rs.next()) {
				batterList.add(new Batterplayer(rs.getString("name"), rs.getInt("salary"), 
						rs.getInt("deposit"), rs.getString("position"),rs.getInt("number"),
						rs.getDouble("avg"), rs.getInt("hr"),rs.getInt("sb")));
			}
		return batterList;
		}
	}

}
