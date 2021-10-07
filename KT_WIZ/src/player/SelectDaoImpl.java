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
		String sql ="select * from pitcher order by "+columnName+" "+orderBy;
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
		String sql ="select * from batter order by "+columnName+" "+orderBy;
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
		String sql ="select * from pitcher "+columnName+" order by "+columnName+" "+orderBy+" limit "+num;
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
		String sql ="select * from batter "+columnName+" order by "+columnName+" "+orderBy+" limit "+num;
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
		String sql = "select * from pitcher order by salary "+orderBy+ " limit 5";
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
		String sql = "select * from batter order by salary "+orderBy+" limit 10";
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
	
	//타자 입력 받은 타율 보다 타율이 좋은 선수에 기본 급여에 + 얼마할지 
		@Override
		public int update_batter(Batterplayer player) throws ClassNotFoundException, SQLException {
			String sql = "update batter set salary = salary+? where avg >= ?";
			try(Connection conn = PlayerConn.getConn2021();
				PreparedStatement pst = conn.prepareStatement(sql)){
				
				pst.setInt(2, player.getSalary());
				pst.setDouble(1, player.getAvg());
				
				return pst.executeUpdate();
				
			}
		}
		
	    //투수 입력받은 평자 보다 평자가 좋은 선수들에게 원래 급여 + 얼마를 줄지
		@Override
		public int update_pitcher(Pitcherplayer player) throws ClassNotFoundException, SQLException {
			String sql = "update pitcher set salary = slaray+? where avg >= ?";
			try(Connection conn = PlayerConn.getConn2021();
				PreparedStatement pst = conn.prepareStatement(sql)){
				
				pst.setInt(1, player.getSalary());
				pst.setDouble(2, player.getEra());
				
				return pst.executeUpdate();
				
			}
		}
		
	    //연도별 타자 조회
		@Override
		public List<Batterplayer>PlayerYears_batterFindAll(int ans) throws ClassNotFoundException, SQLException {
			String sql = "select * from batter";
			List<Batterplayer> playList = new ArrayList<Batterplayer>();
			
			if(ans == 2019) {
				try(Connection conn = PlayerConn.getConn2019();
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery()){
								
					while(rs.next()) {
						playList.add(new Batterplayer(rs.getString("name"),
								rs.getInt("salary"),
								rs.getInt("deposit"),
								rs.getString("position"),
								rs.getInt("number"),
								rs.getDouble("avg"),
								rs.getInt("hr"),
								rs.getInt("sb")));
					}
					
				}
				
			}else if(ans == 2020) {
				try(Connection conn = PlayerConn.getConn2020();
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery()){
								
					while(rs.next()) {
						playList.add(new Batterplayer(rs.getString("name"),
								rs.getInt("salary"),
								rs.getInt("deposit"),
								rs.getString("position"),
								rs.getInt("number"),
								rs.getDouble("avg"),
								rs.getInt("hr"),
								rs.getInt("sb")));
					}
				}
			}else if(ans == 2021) {
				try(Connection conn = PlayerConn.getConn2021();
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery()){
								
					while(rs.next()) {
						playList.add(new Batterplayer(rs.getString("name"),
								rs.getInt("salary"),
								rs.getInt("deposit"),
								rs.getString("position"),
								rs.getInt("number"),
								rs.getDouble("avg"),
								rs.getInt("hr"),
								rs.getInt("sb")));
					}
				}
			}
			return playList;
		
		}
	    //연도별 투수조회
		@Override
		public List<Pitcherplayer> PlayerYars_pitcherFindAll(int ans) throws ClassNotFoundException, SQLException {
			String sql = "select * from batter";
			List<Pitcherplayer> playList = new ArrayList<Pitcherplayer>();
			
			if(ans == 2019) {
				try(Connection conn = PlayerConn.getConn2019();
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery()){
								
					while(rs.next()) {
						playList.add(new Pitcherplayer(rs.getString("name"),
								rs.getInt("salary"),
								rs.getInt("deposit"),
								rs.getString("position"),
								rs.getInt("number"),
								rs.getDouble("era"),
								rs.getInt("phr"),
								rs.getInt("win"),
								rs.getInt("lose"),
								rs.getInt("sv")));
					}
					
				}
				
			}else if(ans == 2020) {
				try(Connection conn = PlayerConn.getConn2020();
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery()){
								
					while(rs.next()) {
						playList.add(new Pitcherplayer(rs.getString("name"),
								rs.getInt("salary"),
								rs.getInt("deposit"),
								rs.getString("position"),
								rs.getInt("number"),
								rs.getDouble("era"),
								rs.getInt("phr"),
								rs.getInt("win"),
								rs.getInt("lose"),
								rs.getInt("sv")));
					}
					
				}
			}else if(ans == 2021) {
				try(Connection conn = PlayerConn.getConn2021();
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery()){
								
					while(rs.next()) {
						playList.add(new Pitcherplayer(rs.getString("name"),
								rs.getInt("salary"),
								rs.getInt("deposit"),
								rs.getString("position"),
								rs.getInt("number"),
								rs.getDouble("era"),
								rs.getInt("phr"),
								rs.getInt("win"),
								rs.getInt("lose"),
								rs.getInt("sv")));
					}
					
				}
			}
			return playList;
		
		}

}
