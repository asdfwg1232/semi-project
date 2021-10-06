package BaseBall;

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

	
	public List<PlayerDto_batter> playerFindByAvgOrderBy(String columnName, String ans) throws ClassNotFoundException, SQLException {
		String sql = "select * from batter order where ? ? by avg desc limit 10";
			try(Connection conn = PlayerConn.getConn2021();
					PreparedStatement pst = conn.prepareStatement(sql)){	
				
				pst.setString(1, columnName);
				pst.setString(2, ans);
				
				try(ResultSet rs = pst.executeQuery()){
					
					List<PlayerDto_batter> plaList = new ArrayList<PlayerDto_batter>();
					while(rs.next()) {
						plaList.add(new PlayerDto_batter(
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

	@Override
	public List<PlayerDto_pitcher> playerFindByEraOrderBy(String columnName, String ans)
			throws ClassNotFoundException, SQLException {
		String sql = "select * from pitcher order where ? ? by avg desc limit 10";
		try(Connection conn = PlayerConn.getConn2021();
				PreparedStatement pst = conn.prepareStatement(sql)){	
			
			pst.setString(1, columnName);
			pst.setString(2, ans);
			
			try(ResultSet rs = pst.executeQuery()){
				
				List<PlayerDto_pitcher> plaList = new ArrayList<PlayerDto_pitcher>();
				while(rs.next()) {
					plaList.add(new PlayerDto_pitcher(
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


	@Override
	public int update_batter(PlayerDto_batter player) throws ClassNotFoundException, SQLException {
		String sql = "update batter set salary = salary+? where avg <= ?";
		try(Connection conn = PlayerConn.getConn2021();
			PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(2, player.getSalary());
			pst.setDouble(1, player.getAvg());
			
			return pst.executeUpdate();
			
		}
	}

	@Override
	public int update_pitcher(PlayerDto_pitcher player) throws ClassNotFoundException, SQLException {
		String sql = "update pitcher set salary = slaray+? where avg <= ?";
		try(Connection conn = PlayerConn.getConn2021();
			PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, player.getSalary());
			pst.setDouble(2, player.getEra());
			
			return pst.executeUpdate();
			
		}
	}

	@Override
	public List<PlayerDto_batter>PlayerYears_batterFindAll(int ans) throws ClassNotFoundException, SQLException {
		String sql = "select * from batter";
		List<PlayerDto_batter> playList = new ArrayList<PlayerDto_batter>();
		
		if(ans == 2019) {
			try(Connection conn = PlayerConn.getConn2019();
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery()){
							
				while(rs.next()) {
					playList.add(new PlayerDto_batter(rs.getString("name"),
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
					playList.add(new PlayerDto_batter(rs.getString("name"),
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
					playList.add(new PlayerDto_batter(rs.getString("name"),
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

	@Override
	public List<PlayerDto_pitcher> PlayerYars_pitcherFindAll(int ans) throws ClassNotFoundException, SQLException {
		String sql = "select * from batter";
		List<PlayerDto_pitcher> playList = new ArrayList<PlayerDto_pitcher>();
		
		if(ans == 2019) {
			try(Connection conn = PlayerConn.getConn2019();
					PreparedStatement pst = conn.prepareStatement(sql);
					ResultSet rs = pst.executeQuery()){
							
				while(rs.next()) {
					playList.add(new PlayerDto_pitcher(rs.getString("name"),
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
					playList.add(new PlayerDto_pitcher(rs.getString("name"),
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
					playList.add(new PlayerDto_pitcher(rs.getString("name"),
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

	
