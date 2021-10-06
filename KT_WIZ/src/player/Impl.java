
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {
	private static PlayerDaoImpl instance = new PlayerDaoImpl();
	private PlayerDaoImpl() {}
	
	public static PlayerDaoImpl getInstance() {
		return instance;
	}

	//타자 타율 10명 좋은 사람 고르기
	public List<Batterplayer> playerFindByAvgOrderBy() throws ClassNotFoundException, SQLException {
		String sql = "select * from batter order by avg desc limit 10";
			try(Connection conn = PlayerConn.getConn2021();
					PreparedStatement pst = conn.prepareStatement(sql)){				
				try(ResultSet rs = pst.executeQuery()){
					
					List<Batterplayer> plaList = new ArrayList<Batterplayer>();
					while(rs.next()) {
						plaList.add(new Batterplayer(
								rs.getString("name"),
								rs.getInt("salary"),
								rs.getInt("deposit"),
								rs.getString("position"),
								rs.getInt("number"),
								rs.getDouble("avg"),
								rs.getInt("hr"),
								rs.getInt("sb")));
					}
					return plaList;
				}
			}
		}
	
    //투수 평자 좋은 10명 정렬하기
	@Override
	public List<Pitcherplayer> playerFindByEraOrderBy() throws ClassNotFoundException, SQLException {
		String sql = "select * from pitcher order by era desc limit 10";
		try(Connection conn = PlayerConn.getConn2021();
				PreparedStatement pst = conn.prepareStatement(sql)){					
			try(ResultSet rs = pst.executeQuery()){
				
				List<Pitcherplayer> plaList = new ArrayList<Pitcherplayer>();
				while(rs.next()) {
					plaList.add(new Pitcherplayer(
							rs.getString("name"),
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
				return plaList;
			}
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
