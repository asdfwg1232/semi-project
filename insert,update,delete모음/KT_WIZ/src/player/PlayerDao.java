package player;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

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
	
	//투수 타자 메모장에 쓰기
	public void writeBatterplayerFile(String dir,String name,List<Batterplayer> playList) throws IOException, ClassNotFoundException, SQLException;
	
	public void writePitcherplayerFile(String dir, String name, List<Pitcherplayer> playList) throws IOException, ClassNotFoundException, SQLException;
	
	//투수 타자 쓰기
	public List<Batterplayer> readBatterplayerFile(Reader input) throws ClassNotFoundException, IOException, SQLException;
	
	public List<Batterplayer> readFile_batter(File file) throws IOException, ClassNotFoundException, SQLException;
	
        public List<Pitcherplayer> readPitcherplayerFile(Reader input) throws ClassNotFoundException, IOException, SQLException;
	
	public List<Pitcherplayer> readFile_pitcher(File file) throws IOException, ClassNotFoundException, SQLException;
	
	//타자 조회, 투수 조회
	public List<Batterplayer> PlayerYears_batterFindAll() throws ClassNotFoundException, SQLException;
	
        public List<Pitcherplayer> PlayerYars_pitcherFindAll() throws ClassNotFoundException, SQLException;

}
