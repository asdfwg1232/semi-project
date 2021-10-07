package player;

import java.sql.SQLException;

public interface PlayerDao {
	
//	선수 정보를 입력하는 input 

	public int insertPitcher(Pitcherplayer pitcherplayer) throws ClassNotFoundException, SQLException ;
	public int insertBatter(Batterplayer batterplayer) throws ClassNotFoundException, SQLException;

	//	선수들의 기록을 수정하는 update

	public int Pitcherupdate(String name, double era, int phr, int win, int lose, int sv) throws ClassNotFoundException, SQLException;
	public int updateBatter(String name, double avg, int hr, int sb) throws ClassNotFoundException, SQLException;


	//	삭제하는 delete

	int Pitcherdelete(String name) throws ClassNotFoundException, SQLException;
	int Batterdelete(String name) throws ClassNotFoundException, SQLException;

	//타자 연봉올리기
	public int update_batter(double avg, int salr) throws ClassNotFoundException, SQLException;

	//투수 연봉올리기
	public int update_pitcher(double era, int sal) throws ClassNotFoundException, SQLException;
}
