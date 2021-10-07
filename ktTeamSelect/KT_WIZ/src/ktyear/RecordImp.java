package ktyear;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordImp implements RecordDao {
	
	public static RecordImp instance = new RecordImp();
	
	private  RecordImp() {}
	
	public static RecordImp getinst() {
		return instance;
	}
	
	//pitcher 중복방지용
	
	private KTWIZ_Pitcher pmethod(ResultSet rs) throws SQLException {
		return new KTWIZ_Pitcher(rs.getInt("year"), rs.getInt("rank"), rs.getDouble("era"), rs.getInt("phr"), rs.getInt("win"),rs.getInt("lose") , rs.getInt("sv"));
		
	}
	
	private KTWIZ_Batter bmethod(ResultSet rs) throws SQLException {
		return new KTWIZ_Batter(rs.getInt("year"), rs.getInt("rank"), rs.getDouble("avg"), rs.getInt("hr"), rs.getInt("run"), rs.getInt("hit"));
	}
	
	
	@Override
	public List<KTWIZ_Pitcher> pitcherAll() throws ClassNotFoundException, SQLException{

		String str = "select * from ktpitcher";

		try(Connection conn = PlayerConn1.getConnkt();
				PreparedStatement pst = conn.prepareStatement(str);
				ResultSet rs = pst.executeQuery()) {

			List<KTWIZ_Pitcher> listp = new ArrayList<KTWIZ_Pitcher>();
			List<String> strlist = new ArrayList<String>();

			while(rs.next()) {

				listp.add(pmethod(rs));
			
			}

			return listp;

		} 
	}
	@Override
	public List<KTWIZ_Batter> batterAll() throws ClassNotFoundException, SQLException {
		
		String str = "select * from ktbatter";

		try(Connection conn = PlayerConn1.getConnkt();
				PreparedStatement pst = conn.prepareStatement(str);
				ResultSet rs = pst.executeQuery()) {

			List<KTWIZ_Batter> listp1 = new ArrayList<KTWIZ_Batter>();

			while(rs.next()) {

				listp1.add(bmethod(rs));
			}

			return listp1;

		} 
	}

	@Override
	public List<KTWIZ_Pitcher> pitcherRecord(int year) throws ClassNotFoundException, SQLException {
		
		String str = "select * from ktpitcher where year = ?";
		
		try(Connection conn = PlayerConn1.getConnkt();
				PreparedStatement pst = conn.prepareStatement(str)){
			
			pst.setInt(1, year);
			
			try(ResultSet rs = pst.executeQuery()){
				
				List<KTWIZ_Pitcher> list2 = new ArrayList<KTWIZ_Pitcher>();
				
				while(rs.next()) {
					list2.add(pmethod(rs));
				}
				return list2;
			}
			
			
		}
		
	}

	@Override
	public List<KTWIZ_Batter> batterRecord(int year) throws ClassNotFoundException, SQLException {
		
		String str = "select * from ktbatter where year = ?";
		
		try(Connection conn = PlayerConn1.getConnkt();
				PreparedStatement pst = conn.prepareStatement(str)){
			
			pst.setInt(1, year);
			
			try(ResultSet rs = pst.executeQuery()){
				
				List<KTWIZ_Batter> list3 =  new ArrayList<KTWIZ_Batter>();
				
				while(rs.next()) {
					list3.add(bmethod(rs));
				}
				return list3;
			}
			
		}
		
		
	}

//	@Override
//	public List<KTWIZ_Pitcher> pitcherRank() throws ClassNotFoundException, SQLException {
//		String str = "select * from ktpitcher order by rank desc limt 1";
//
//		try(Connection conn = PlayerConn1.getConnkt();
//				PreparedStatement pst = conn.prepareStatement(str);
//				ResultSet rs = pst.executeQuery()) {
//
//			List<KTWIZ_Pitcher> listp = new ArrayList<KTWIZ_Pitcher>();
//			List<String> strlist = new ArrayList<String>();
//
//			while(rs.next()) {
//
//				listp.add(pmethod(rs));
//			
//			}
//
//			return listp;
//
//		} 
//	}
//
//	@Override
//	public List<KTWIZ_Batter> batterRank() throws ClassNotFoundException, SQLException {
//		String str = "select * from ktbatter order by rank desc limt 1";
//		
//		try(Connection conn = PlayerConn1.getConnkt();
//				PreparedStatement pst = conn.prepareStatement(str);
//				ResultSet rs = pst.executeQuery()) {
//
//			List<KTWIZ_Batter> listp1 = new ArrayList<KTWIZ_Batter>();
//
//			while(rs.next()) {
//
//				listp1.add(bmethod(rs));
//			}
//
//			return listp1;
//
//		} 
//		
//	}
	
	
	

}
