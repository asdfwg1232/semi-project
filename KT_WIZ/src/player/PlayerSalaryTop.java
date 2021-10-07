package player;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PlayerSalaryTop {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		

		System.out.println("타자 연봉 top10, 투수 연봉 top5 조회");
		System.out.println("타자 or 투수");
		String str = scan.next();
		
		if(str.equals("타자")) {
			
			SelectDao dao = SelectDaoImpl.getInstance();
			
			try {
				List<Batterplayer> btList = dao.bSalaryLimit();
				
				for(Batterplayer batter : btList) {
					System.out.println(batter);
				}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}if(str.equals("투수")) {

			SelectDao dao = SelectDaoImpl.getInstance();
			
			try {
				List<Pitcherplayer> pcList = dao.pSalaryLimit();
				
				for(Pitcherplayer pitcher : pcList) {
					System.out.println(pitcher);
				}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
