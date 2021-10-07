package ktyear;

import java.sql.SQLException;
import java.util.List;

public interface RecordDao {
	
	//kt팀의 연도별  투수, 타자의 종합 성적을 구함
	//pitcher
	public List<KTWIZ_Pitcher> pitcherAll() throws ClassNotFoundException, SQLException ;
	public List<KTWIZ_Batter> batterAll() throws ClassNotFoundException, SQLException;
	
	//kt팀의 연도별 투수/타자의 특정부분에 대한 성적 구함
	public List<KTWIZ_Pitcher> pitcherRecord(int year, String name) throws ClassNotFoundException, SQLException;
	public List<KTWIZ_Batter> batterRecord(int year, String name) throws ClassNotFoundException, SQLException;
	
	

}
