package down;

import java.sql.SQLException;
import java.util.List;

public interface SelectDao {

	//투수 전체 컬럼으로 조회
	public List<Pitcherplayer> pitcherOrderBy(String columnName, String orderBy) throws ClassNotFoundException, SQLException;
	
	//타자 전체 컬럼으로 조회
	public List<Batterplayer> batterOrderBy(String columnName,String orderBy ) throws ClassNotFoundException, SQLException;
	
	//투수 컬럼으로 limit조회
	public List<Pitcherplayer> pitcherFindLimit(String columnName, String orderBy, int num) throws ClassNotFoundException, SQLException;
	
	//타자 컬럼으로 limit조회
	public List<Batterplayer> batterFindLimit(String columnName, String orderBy, int num) throws ClassNotFoundException, SQLException;
	
	//투수 연봉 top 5명 조회
	public List<Pitcherplayer> pSalaryLimit() throws ClassNotFoundException, SQLException;
	
	//타자 연봉 top 10명 조회
	public List<Batterplayer> bSalaryLimit() throws ClassNotFoundException, SQLException;
	
	//타자 연봉올리기
//	public int update_batter(double avg, int salr) throws ClassNotFoundException, SQLException;
//		
//	//투수 연봉올리기
//	public int update_pitcher(double era, int sal) throws ClassNotFoundException, SQLException;
//		
//	//년도별 타자 조회
//	public List<Batterplayer> PlayerYears_batterFindAll(int ans) throws ClassNotFoundException, SQLException;
//		
//	//년도별 투수 조회
//	public List<Pitcherplayer> PlayerYars_pitcherFindAll(int ans) throws ClassNotFoundException, SQLException;
		
	
}
