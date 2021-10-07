package player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PlayerImp implements PlayerDao{

	public static PlayerImp instance = new PlayerImp();

	//생성자

	private PlayerImp() {}

	public static PlayerImp getInst() {
		return instance ;
	}
	
   //insert pitcher
	@Override
	public int insertPitcher(Pitcherplayer pitcherplayer) throws ClassNotFoundException, SQLException{
		String str = "insert into pitcher values (?,?,?,?,?,?,?,?,?,?)";
		
		try(Connection conn = PlayerConn.getConn2021();
			PreparedStatement pst = conn.prepareStatement(str)){
			
				pst.setString(1, pitcherplayer.getName());
				pst.setInt(2, pitcherplayer.getSalary());
				pst.setInt(3, pitcherplayer.getDeposit());
				pst.setString(4, pitcherplayer.getPosition());
				pst.setInt(5, pitcherplayer.getNumber());
				pst.setDouble(6, pitcherplayer.getEra());
				pst.setInt(7, pitcherplayer.getPhr());
				pst.setInt(8, pitcherplayer.getWin());
				pst.setInt(9, pitcherplayer.getLose());
				pst.setInt(10, pitcherplayer.getSv());
				
				return pst.executeUpdate();
			}
	}
	
	
//	insert batter
	@Override
	public int insertBatter(Batterplayer batterplayer) throws ClassNotFoundException, SQLException{
		String str = "INSERT INTO batter VALUES (?,?,?,?,?,?,?,?)";
		
		try(Connection conn = PlayerConn.getConn2021();
			PreparedStatement pst = conn.prepareStatement(str)){
		
			pst.setString(1, batterplayer.getName());
			pst.setInt(2, batterplayer.getSalary());
			pst.setInt(3, batterplayer.getDeposit());
			pst.setString(4, batterplayer.getPosition());
			pst.setInt(5, batterplayer.getNumber());
			pst.setDouble(6, batterplayer.getAvg());
			pst.setInt(7, batterplayer.getHr());
			pst.setInt(8, batterplayer.getSb());
			
			return pst.executeUpdate();
			}

	}

//-----------------------------------------------
	
	@Override
	public int Pitcherupdate(String name, double era, int phr, int win, int lose, int sv) throws ClassNotFoundException, SQLException{
		String str = "update pitcher set era =? , phr =?, win =?, lose =?, sv =? where name = ? ";
		
		try(Connection conn = PlayerConn.getConn2021();
				PreparedStatement pst =conn.prepareStatement(str)){
				
			pst.setDouble(1, era);
			pst.setInt(2, phr);
			pst.setInt(3, win);
			pst.setInt(4, lose);
			pst.setInt(5, sv);
			pst.setString(6, name);

			return pst.executeUpdate();
			}
		
	}

	@Override
	public int updateBatter(String name, double avg, int hr, int sb) throws ClassNotFoundException, SQLException {
		String str = "update batter set avg = ?, hr =?, sb =? where name =? ";
		
		try(Connection conn = PlayerConn.getConn2021();
			PreparedStatement pst =conn.prepareStatement(str)){
			
			pst.setDouble(1, avg);
			pst.setInt(2, hr);
			pst.setInt(3, sb);
			pst.setString(4, name);
			
			return pst.executeUpdate();
		}
		
	}

//-----------------------------------------------

	@Override
	public int Pitcherdelete(String name) throws ClassNotFoundException, SQLException{
		String str = "delete from pitcher where name = ?";
		
		try(Connection conn = PlayerConn.getConn2021();
			PreparedStatement pst =conn.prepareStatement(str)){
			
			pst.setString(1, name);
			
			return pst.executeUpdate();
		}
		
	}

	@Override
	public int Batterdelete(String name) throws ClassNotFoundException, SQLException {
		String str = "delete from batter where name = ?";
		
		try(Connection conn = PlayerConn.getConn2021();
				PreparedStatement pst =conn.prepareStatement(str)){
			
			pst.setString(1, name);
			
			return pst.executeUpdate();
		}
		
	}

	//-------------------------------------------------
	
	//타자 입력 받은 타율 보다 타율이 좋은 선수에 기본 급여에 + 얼마할지 
			@Override
			public int update_batter(double avg, int sal) throws ClassNotFoundException, SQLException {
				String sql = "update batter set salary = salary+? where avg >= ?";
				try(Connection conn = PlayerConn.getConn2021();
					PreparedStatement pst = conn.prepareStatement(sql)){
					
					pst.setInt(1, sal);
					pst.setDouble(2, avg);
					
					return pst.executeUpdate();
					
				}
			}
			
		    //투수 입력받은 평자 보다 평자가 좋은 선수들에게 원래 급여 + 얼마를 줄지
			@Override
			public int update_pitcher(double era, int sal) throws ClassNotFoundException, SQLException {
				String sql = "update pitcher set salary = salary+? where era <= ?";
				try(Connection conn = PlayerConn.getConn2021();
					PreparedStatement pst = conn.prepareStatement(sql)){
					
					pst.setInt(1, sal);
					pst.setDouble(2, era);
					
					return pst.executeUpdate();
					
				}
			}


	

}
