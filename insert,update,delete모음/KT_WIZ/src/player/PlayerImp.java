package player;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerImp implements PlayerDao{

	private static PlayerImp instance = new PlayerImp();
	public PlayerImp() {};
	
	public List<Batterplayer> infoList_batter = new ArrayList<Batterplayer>();
	public List<Pitcherplayer> infoList_pitcher = new ArrayList<Pitcherplayer>();
	
	public void setInfoList_Batter(List<Batterplayer> InfoList_batter) {
		this.infoList_batter = InfoList_batter;
	}
	public void setInfoList_pitcher(List<Pitcherplayer> InfoList_pitcher) {
		this.infoList_pitcher = InfoList_pitcher;
	}
	
	
	public static PlayerImp getInst() {
	        return instance;
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
			
			@Override
			public void writeBatterplayerFile(String dir,String name,List<Batterplayer> playList)
					throws IOException, ClassNotFoundException, SQLException {
//				playList  = new ArrayList<Batterplayer>();
				String sql = "select * from batter";
				File outFile = new File(dir, name);
					try(Connection conn = PlayerConn.getConn2021();
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))){
						
						File information = new File(dir);
						
			
						if(!information.exists()) {
							information.mkdir();
						}
						if(outFile.exists()) {
							outFile.delete();
						}
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
//						out = new BufferedOutputStream(new FileOutputStream(outFile));
						for(int idx = 0; idx < playList.size()-2; idx++) {
							String writeStr = playList.get(idx).getName()+","+ playList.get(idx).getSalary()+","+
						playList.get(idx).getDeposit()+","+playList.get(idx).getPosition()+","+playList.get(idx).getNumber()+","+
									playList.get(idx).getAvg()+","+playList.get(idx).getHr()+","+playList.get(idx).getSb()+"\n";
						
						byte[] b = writeStr.getBytes();
						
						//파일에 해당 내용을 쓴다.
						out.write(b);
						}
					}
			}
			
			public void writePitcherplayerFile(String dir,String name,List<Pitcherplayer> playList)
					throws IOException, ClassNotFoundException, SQLException {
//				playList  = new ArrayList<Batterplayer>();
				String sql = "select * from pitcher";
				File outFile = new File(dir, name);
					try(Connection conn = PlayerConn.getConn2021();
						PreparedStatement pst = conn.prepareStatement(sql);
						ResultSet rs = pst.executeQuery();
						OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))){
						
						File information = new File(dir);
						
			
						if(!information.exists()) {
							information.mkdir();
						}
						if(outFile.exists()) {
							outFile.delete();
						}
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
//						out = new BufferedOutputStream(new FileOutputStream(outFile));
						for(int idx = 0; idx < playList.size()-2; idx++) {
							String writeStr = playList.get(idx).getName()+","+ playList.get(idx).getSalary()+","+
						playList.get(idx).getDeposit()+","+playList.get(idx).getPosition()+","+playList.get(idx).getNumber()+","+
									playList.get(idx).getEra()+","+playList.get(idx).getPhr()+","+playList.get(idx).getWin()+","+
						playList.get(idx).getLose()+","+playList.get(idx).getSv()+"\n";
						
						byte[] b = writeStr.getBytes();
						
						//파일에 해당 내용을 쓴다.
						out.write(b);
						}
					}
			}
			@Override
			public List<Batterplayer> readFile_batter(File file) throws IOException, ClassNotFoundException, SQLException {
				List<Batterplayer> InfoList = new ArrayList<Batterplayer>();
				FileReader filereader = null;
				try{
					filereader = new FileReader(file);
					InfoList = readBatterplayerFile(filereader);
				}finally {
					if(filereader != null) {filereader.close();}
					
				} 
				return InfoList;
		}	
			

			@Override
			public List<Batterplayer> readBatterplayerFile(Reader input) throws ClassNotFoundException, IOException, SQLException {
				try{
					BufferedReader in = new BufferedReader(input);
			        String line;
			        
					List<Batterplayer> InfoList = new ArrayList<Batterplayer>();
				
					
					while((line = in.readLine()) != null) {
						String[] writeStr = line.split(",");
						
						Batterplayer bp = new Batterplayer();
						
						bp.setName(writeStr[0]);
						bp.setSalary(Integer.parseInt(writeStr[1]));
						bp.setDeposit(Integer.parseInt(writeStr[2]));
						bp.setPosition(writeStr[3]);
						bp.setNumber(Integer.parseInt(writeStr[4]));
						bp.setAvg(Double.parseDouble(writeStr[5]));
						bp.setHr(Integer.parseInt(writeStr[6]));
						bp.setSb(Integer.parseInt(writeStr[7]));
						InfoList.add(bp);
					}
					return InfoList;
				}finally {input.close();}
			}

			@Override
			public List<Pitcherplayer> readFile_pitcher(File file) throws IOException, ClassNotFoundException, SQLException {
				List<Pitcherplayer> InfoList = new ArrayList<Pitcherplayer>();
				FileReader filereader = null;
				try{
					filereader = new FileReader(file);
					InfoList =  readPitcherplayerFile(filereader);
				}finally {
					if(filereader != null) {filereader.close();}
					
				} 
				return InfoList;
				
			}

			@Override
			public List<Pitcherplayer> readPitcherplayerFile(Reader input)
					throws ClassNotFoundException, IOException, SQLException {
				try{
					BufferedReader in = new BufferedReader(input);
			        String line;
			        
					List<Pitcherplayer> InfoList = new ArrayList<Pitcherplayer>();
				
					
					while((line = in.readLine()) != null) {
						String[] writeStr = line.split(",");
						
						Pitcherplayer pp = new Pitcherplayer();
						
						pp.setName(writeStr[0]);
						pp.setSalary(Integer.parseInt(writeStr[1]));
						pp.setDeposit(Integer.parseInt(writeStr[2]));
						pp.setPosition(writeStr[3]);
						pp.setNumber(Integer.parseInt(writeStr[4]));
						pp.setEra(Double.parseDouble(writeStr[5]));
						pp.setPhr(Integer.parseInt(writeStr[6]));
						pp.setWin(Integer.parseInt(writeStr[7]));
						pp.setLose(Integer.parseInt(writeStr[8]));
						pp.setSv(Integer.parseInt(writeStr[9]));
						InfoList.add(pp);
					}
					return InfoList;
				}finally {input.close();}
			}

			//타자 조회
			public List<Batterplayer>PlayerYears_batterFindAll() throws ClassNotFoundException, SQLException {
				String sql = "select * from batter";
				List<Batterplayer> playList = new ArrayList<Batterplayer>();
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
					return playList;
			}
		    //투수조회
			@Override
			public List<Pitcherplayer> PlayerYars_pitcherFindAll() throws ClassNotFoundException, SQLException {
				String sql = "select * from pitcher";
				List<Pitcherplayer> playList = new ArrayList<Pitcherplayer>();
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
					return playList;
				}
}
