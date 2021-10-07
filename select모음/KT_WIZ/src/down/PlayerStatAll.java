package down;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PlayerStatAll {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("어떤 포지션을 조회 하시겠습니까?");
		System.out.println("타자 or 투수");
		String str = scan.next();
		
		if(str.equals("타자")) {
			String[] columns = {"avg", "hr", "sb"};
			
			System.out.println("조회할 기록을 선택하세요");
			for(int i =0; i<columns.length;i++) {
				System.out.println(i+". "+columns[i]);
			}
			
			int columnNum =scan.nextInt();
			
			System.out.println("정렬방식을 숫자로 선택하세요");
			System.out.println("1.오름차순");
			System.out.println("2.내림차순");
			
			int orderByNum = scan.nextInt();
			String orderBy = (orderByNum == 1 ? "asc" : "desc");
			
			SelectDao dao = SelectDaoImpl.getInstance();
			
			try {
				List<Batterplayer> btList = dao.batterOrderBy(columns[columnNum], orderBy);
				
				for(Batterplayer batter : btList) {
					System.out.println(batter);
				}
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}if(str.equals("투수")) {
			String[] columns = {"era", "phr", "win","lose","sv"};
			
			System.out.println("조회할 기록을 선택하세요");
			for(int i =0; i<columns.length;i++) {
				System.out.println(i+". "+columns[i]);
			}
			
			int columnNum =scan.nextInt();
			
			System.out.println("정렬방식을 숫자로 선택하세요");
			System.out.println("1.오름차순");
			System.out.println("2.내림차순");
			
			int orderByNum = scan.nextInt();
			String orderBy = (orderByNum == 1 ? "asc" : "desc");
			
			SelectDao dao = SelectDaoImpl.getInstance();
			
			try {
				List<Pitcherplayer> pcList = dao.pitcherOrderBy(columns[columnNum], orderBy);
				
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
