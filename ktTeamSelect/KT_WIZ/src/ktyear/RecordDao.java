package ktyear;

import java.sql.SQLException;
import java.util.List;

public interface RecordDao {
	
	//kt팀의 연도별  투수, 타자의 종합 성적을 구함
	//pitcher
	public List<KTWIZ_Pitcher> pitcherAll() throws ClassNotFoundException, SQLException ;
	public List<KTWIZ_Batter> batterAll() throws ClassNotFoundException, SQLException;
	
	//kt팀의 연도별 투수/타자의 성적 구함
	public List<KTWIZ_Pitcher> pitcherRecord(int year) throws ClassNotFoundException, SQLException;
	public List<KTWIZ_Batter> batterRecord(int year) throws ClassNotFoundException, SQLException;
	
//	//kt팀이 1위를 했을때의 성적 구하기
//	public List<KTWIZ_Pitcher> pitcherRank() throws ClassNotFoundException, SQLException;
//	public List<KTWIZ_Batter> batterRank() throws ClassNotFoundException, SQLException;
	
}
