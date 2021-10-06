package player;

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
	public List<Pitcherplayer> pSalaryLimit(String orderBy) throws ClassNotFoundException, SQLException;
	
	//타자 연봉 top 10명 조회
	public List<Batterplayer> bSalaryLimit(String orderBy) throws ClassNotFoundException, SQLException;
	
}
